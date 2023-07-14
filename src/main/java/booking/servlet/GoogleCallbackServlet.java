package booking.servlet;

import booking.Service.UserService;
import booking.Utils.GoogleConstants;
import booking.Utils.Validator;
import booking.beans.User;
import booking.dto.GoogleUser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


@WebServlet("/callback")
public class GoogleCallbackServlet extends HttpServlet {
    private final UserService userService = new UserService();
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String code = request.getParameter("code");
            ///----------------------------------------Process parse access key of google-------------------------------------------------------------///
            HttpTransport transport = new NetHttpTransport();
            JsonFactory jsonFactory = new GsonFactory();
            GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(
                    transport, jsonFactory,
                    "https://oauth2.googleapis.com/token",
                    GoogleConstants.CLIENT_ID,
                    GoogleConstants.CLIENT_SECRET,
                    code,
                    GoogleConstants.REDIRECT_URI)
                    .execute();

            String accessToken = tokenResponse.getAccessToken();
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("https://www.googleapis.com/oauth2/v2/userinfo");
            httpGet.addHeader("Authorization", "Bearer " + accessToken);
            HttpResponse userInfoResponse = httpClient.execute(httpGet);
            HttpEntity entity = userInfoResponse.getEntity();


            String userInfoJsonString = EntityUtils.toString(entity);


            Gson gson = new Gson();
            GoogleUser user = gson.fromJson(userInfoJsonString, GoogleUser.class);
            String userEmail = user.getEmail();
            //--------------Add value into map-----------------------//
            Map<String, String> values = new HashMap<>();
            values.put("userEmail", userEmail);
            //--------------Validation -----------------------//
            Map<String, List<String>> violations = new HashMap<>();
            Optional<User> userFromServer = userService.getByEmail(userEmail);//
            violations.put("usernameViolations", Validator.of(values.get("userEmail"))
                    .isNotNullAndEmpty()
                    .isNotBlankAtBothEnds()
                    .isExistent(userFromServer.isPresent(), "Tên đăng nhập")
                    .toList());
            //--------------End  -----------------------//
            int sumOfViolations = violations.values().stream().mapToInt(List::size).sum();
            if (sumOfViolations == 0 && userFromServer.isPresent()) {
                User userValue = userFromServer.get();
                if (Arrays.asList("ADMIN", "EMPLOYEE").contains(userValue.getRole())) {
                    request.getSession().setAttribute("currentUser", userValue);
                    response.sendRedirect(request.getContextPath() + "/admin");
                }
            } else {
                request.setAttribute("values", values);
                request.setAttribute("violations", violations);
                request.getRequestDispatcher("/WEB-INF/views/signinAdminView.jsp").forward(request, response);
            }


        }

}
