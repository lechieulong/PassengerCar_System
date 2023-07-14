package booking.servlet.admin.user;

import booking.Service.UserService;
import booking.beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "userManager",value = "/admin/userManager")
public class userManagerServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private static final int USERS_PER_PAGE = 3;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int totalUsers = userService.count();
        int totalPages = totalUsers / USERS_PER_PAGE + (totalUsers % USERS_PER_PAGE != 0 ? 1 : 0);

        String pageParam = Optional.ofNullable(req.getParameter("page")).orElse("1");
        int page = Integer.parseInt(pageParam);
        if (page < 1 || page > totalPages) {
            page = 1;
        }

        int offset = (page - 1) * USERS_PER_PAGE;

        List<User> users =  userService.getOrderedPart(
                USERS_PER_PAGE, offset, "id", "DESC"
        );

        req.setAttribute("totalPages", totalPages);
        req.setAttribute("page", page);
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/views/userManagerView.jsp").forward(req,resp);
    }
}
