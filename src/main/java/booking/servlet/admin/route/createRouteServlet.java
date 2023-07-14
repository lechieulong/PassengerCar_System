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

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "createRoute", value = "/admin/routeManager/create")
public class createRouteServlet extends HttpServlet {
    private final RouteService routeService = new RouteService();
    private final CitiesService citiesService = new CitiesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cities> cityFromServer = citiesService.getAll();
        req.setAttribute("cityFromServer",cityFromServer);
        req.getRequestDispatcher("/WEB-INF/views/routeCreateView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Route route = new Route();
        route.setName(req.getParameter("name"));
        route.setPickUpPoint(Long.parseLong(req.getParameter("pickUpPoint")));
        route.setDropOffPoint(Long.parseLong(req.getParameter("dropOffPoint")));

        //------------------------Validation Time !------------------------------------//
        Map<String, List<String>> violations = new HashMap<>();
        Optional<Route> routeFromServer = routeService.getByName(route.getName());
        violations.put("name",Validator.of(route.getName())
                .isNotNullAndEmpty()
                .isNotBlankAtBothEnds()
                .isNotExistent(routeFromServer.isPresent(),"Quãng đường  ")
                .toList());

        int sumOfViolation = violations.values().stream().mapToInt(List::size).sum();
        //------------------------- End -----------------------------------//
        String successMessage = "Thêm thành công";
        String errorMessage = "Thêm thất bại ";
        if (sumOfViolation == 0){
            try {
                routeService.insert(route);
                req.setAttribute("cityFromServer",citiesService.getAll());
                req.setAttribute("successMessage", successMessage);
            }
            catch(Exception e) {
                req.setAttribute("cityFromServer",citiesService.getAll());
                req.setAttribute("route", route);
                req.setAttribute("errorMessage", errorMessage);
            }
            req.getRequestDispatcher("/WEB-INF/views/routeCreateView.jsp").forward(req,resp);
        }else {
            req.setAttribute("cityFromServer",citiesService.getAll());
            req.setAttribute("route", route);
            req.setAttribute("violations", violations);
            req.getRequestDispatcher("/WEB-INF/views/routeCreateView.jsp").forward(req,resp);
        }
    }
}
