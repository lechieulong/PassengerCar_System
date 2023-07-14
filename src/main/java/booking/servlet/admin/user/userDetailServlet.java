package booking.servlet.admin.user;

import booking.Service.UserService;
import booking.beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

@WebServlet(name = "detailUser",value = "/admin/userManager/detail")

public class userDetailServlet extends HttpServlet {
    private final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id =  Long.parseLong(req.getParameter("id"));
        Optional<User> userFromServer = userService.getById(id);
        if (userFromServer.isPresent()) {
            req.setAttribute("user", userFromServer.get());
            req.getRequestDispatcher("/WEB-INF/views/userDetailView.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/admin/userManager");
        }
    }

}
