package booking.servlet.admin;

import booking.Service.RouteService;
import booking.Service.TransportService;
import booking.Service.UserService;
import booking.beans.Transport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final TransportService transportService = new TransportService();

    private final RouteService routeService = new RouteService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        int totalUsers = userService.count();
        int totalTransport = transportService.count();
        int totalRoute = routeService.count();
        request.setAttribute("totalRoute", totalRoute);
        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("totalTransport", totalTransport);
        request.getRequestDispatcher("/WEB-INF/views/adminView.jsp").forward(request, response);
    }

}
