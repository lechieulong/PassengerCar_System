package booking.servlet.client;

import booking.Service.UserService;
import booking.beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@WebServlet(name = "SettingServlet", value = "/setting")
public class SettingServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");
        req.setAttribute("user", user);
        req.getRequestDispatcher("WEB-INF/views/settingView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        Map<String, String> values = new HashMap<>();
        values.put("username", req.getParameter("username"));
        values.put("fullname", req.getParameter("fullname"));
        values.put("email", req.getParameter("email"));
        values.put("phoneNumbers", req.getParameter("phoneNumber"));
        values.put("gender", req.getParameter("gender"));
        values.put("address", req.getParameter("address"));

        User newUser = new User(
                user.getId(),
                values.get("username"),
                user.getPassword(),
                values.get("fullname"),
                values.get("email"),
                values.get("phoneNumbers"),
                Integer.parseInt(values.get("gender")),
                values.get("address"),
                "CUSTOMER"
        );

        String successMessage = "Cập nhật thành công!";
        String errorMessage = "Cập nhật không thành công!";

        Optional<User> userWithNewUsername = userService.getByUsername(values.get("username"));

        if (!user.getUsername().equals(values.get("username")) && userWithNewUsername.isPresent()) {
            req.setAttribute("errorMessage", errorMessage);
            req.setAttribute("user", user);
        } else {
            userService.update(newUser);
            req.setAttribute("successMessage", successMessage);
            req.setAttribute("user", newUser);
            req.getSession().setAttribute("currentUser", newUser);
        }

        req.getRequestDispatcher("WEB-INF/views/settingView.jsp").forward(req, resp);
    }
}
