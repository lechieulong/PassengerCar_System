package booking.servlet.admin.user;

import booking.Service.UserService;
import booking.beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "deleteUser",value = "/admin/userManager/delete")
public class deleteUserServlet extends HttpServlet {
    private final UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Optional<User> userFromServer = userService.getById(id);
        if (userFromServer.isPresent()) {
            userService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/userManager");
        }


    }
}
