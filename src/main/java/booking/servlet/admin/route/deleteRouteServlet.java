package booking.servlet.admin.route;

import booking.Service.RouteService;
import booking.beans.Cities;
import booking.beans.Route;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "deleteRoute", value = "/admin/routeManager/delete")
public class deleteRouteServlet extends HttpServlet {
    private final RouteService routeService = new RouteService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Optional<Route> routeFromServer = routeService.getById(id);
        if (routeFromServer.isPresent()) {
            routeService.delete(routeFromServer.get().getId());
            resp.sendRedirect(req.getContextPath() + "/admin/routeManager");
        }

    }
}
