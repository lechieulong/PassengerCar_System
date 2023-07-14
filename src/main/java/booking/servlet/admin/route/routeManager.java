package booking.servlet.admin.route;

import booking.Service.CitiesService;
import booking.Service.RouteService;
import booking.Utils.Validator;
import booking.beans.Cities;
import booking.beans.Route;
import booking.beans.Transport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@WebServlet(name = "managerRoute", value = "/admin/routeManager")
public class routeManager extends HttpServlet {
    private final RouteService routeService = new RouteService();
    private static final int ROUTE_PER_PAGE = 5;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int totalRoute = routeService.count();
        int totalPages = totalRoute / ROUTE_PER_PAGE + (totalRoute % ROUTE_PER_PAGE != 0 ? 1 : 0);

        String pageParam = Optional.ofNullable(req.getParameter("page")).orElse("1");
        int page = Integer.parseInt(pageParam);
        if (page < 1 || page > totalPages) {
            page = 1;
        }
        int offset = (page - 1) * ROUTE_PER_PAGE;
        List<Route> routeList = routeService.getOrderedPart(
                ROUTE_PER_PAGE, offset, "id", "DESC"
        );
        req.setAttribute("routeFromServer", routeList);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/WEB-INF/views/routeManagerView.jsp").forward(req,resp);
    }


}
