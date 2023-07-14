package booking.servlet.admin;

import booking.Service.UserService;
import booking.Utils.Validator;
import booking.beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet(name = "SigninAdminServlet", value = "/admin/signin")
public class signin extends HttpServlet {
    private final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/signinAdminView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> values = new HashMap<>();
        values.put("username", req.getParameter("username"));
        values.put("password", req.getParameter("password"));
        Map<String, List<String>> violations = new HashMap<>();
        Optional<User> userFromServer = userService.getByUsername(values.get("username"));
        violations.put("usernameViolations", Validator.of(values.get("username"))
                .isNotNullAndEmpty()
                .isNotBlankAtBothEnds()
                .isExistent(userFromServer.isPresent(), "Tên đăng nhập")
                .toList());
        violations.put("passwordViolations", Validator.of(values.get("password"))
                .isNotNullAndEmpty()
                .isNotBlankAtBothEnds()
                .isEqualTo(userFromServer.map(User::getPassword).orElse(""), "Mật khẩu")
                .toList());
        int sumOfViolations = violations.values().stream().mapToInt(List::size).sum();
        if (sumOfViolations == 0 && userFromServer.isPresent()) {
            User user = userFromServer.get();
            if (Arrays.asList("ADMIN", "EMPLOYEE").contains(user.getRole())) {
                req.getSession().setAttribute("currentUser", user);
                resp.sendRedirect(req.getContextPath() + "/admin");
            }else{
                req.getSession().setAttribute("currentUser", user);
                resp.sendRedirect(req.getContextPath() + "/");

            }        } else {
            req.setAttribute("values", values);
            req.setAttribute("violations", violations);
            req.getRequestDispatcher("/WEB-INF/views/signinAdminView.jsp").forward(req, resp);
        }
    }
}
