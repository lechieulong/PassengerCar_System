package booking.servlet.client;

import booking.Service.UserService;
import booking.Utils.HashingUtils;
import booking.beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ChangePassword", value = "/changePassword")

public class ChangePasswordServlet extends HomeServlet {
    private final UserService userService = new UserService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/changePasswordView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> values = new HashMap<>();
        values.put("currentPassword", req.getParameter("currentPassword"));
        values.put("newPassword", req.getParameter("newPassword"));
        values.put("newPasswordAgain", req.getParameter("newPasswordAgain"));

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        boolean currentPasswordEqualsUserPassword = values.get("currentPassword").equals(user.getPassword());
        boolean newPasswordEqualsNewPasswordAgain = values.get("newPassword").equals(values.get("newPasswordAgain"));

        if (currentPasswordEqualsUserPassword && newPasswordEqualsNewPasswordAgain) {
            String newPassword = values.get("newPassword");
            userService.changePassword(user.getId(), newPassword);
            String successMessage = "Đổi mật khẩu thành công!";
            req.setAttribute("successMessage", successMessage);
        } else {
            String errorMessage = "Đổi mật khẩu thất bại!";
            req.setAttribute("errorMessage", errorMessage);
        }

        req.getRequestDispatcher("/WEB-INF/views/changePasswordView.jsp").forward(req, resp);
    }
}
