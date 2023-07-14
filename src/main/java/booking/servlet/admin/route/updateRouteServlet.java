package booking.servlet.admin.route;


import booking.Service.CitiesService;
import booking.Service.RouteService;
import booking.Utils.Validator;
import booking.beans.Cities;
import booking.beans.Route;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@WebServlet(name = "updateRoute", value = "/admin/routeManager/update")
public class updateRouteServlet extends HttpServlet {
    private final RouteService routeService = new RouteService();
    private final CitiesService citiesService = new CitiesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        List<Cities> citiesFromServer = citiesService.getAll();
        Optional<Route> routeFromServer = routeService.getById(id);
        if (routeFromServer.isPresent()){
            req.setAttribute("routeFromServer",routeFromServer.get());
            req.setAttribute("citiesFromServer",citiesFromServer);
            req.getRequestDispatcher("/WEB-INF/views/routeUpdateView.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath() + "/admin/routeManager");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Route route = new Route();
        route.setId(Long.parseLong(req.getParameter("id")));
        route.setName(req.getParameter("name"));
        route.setPickUpPoint(Long.parseLong(req.getParameter("pickUpPoint")));
        route.setDropOffPoint(Long.parseLong(req.getParameter("dropOffPoint")));
        //------------------------Validation Time !------------------------------------//
        Map<String, List<String>> violations = new HashMap<>();
        violations.put("name", Validator.of(route.getName()).toList());
        violations.put("pickUpPoint",Validator.of(route.getPickUpPoint()).toList());
        violations.put("dropOffPoint",Validator.of(route.getDropOffPoint()).toList());
        int sumOfViolation = violations.values().stream().mapToInt(List::size).sum();

        //------------------------- End -----------------------------------//
        System.out.println(route);
        if (sumOfViolation == 0) {
            routeService.update(route);
            req.setAttribute("routeFromServer",route);
            req.setAttribute("citiesFromServer", citiesService.getAll());
            req.getRequestDispatcher("/WEB-INF/views/routeUpdateView.jsp").forward(req, resp);
        } else {
            req.setAttribute("routeFromServer", route.getName());
            req.setAttribute("citiesFromServer", citiesService.getAll());
            req.setAttribute("violations", violations);
            req.getRequestDispatcher("/WEB-INF/views/routeUpdateView.jsp").forward(req, resp);
        }



    }
}
