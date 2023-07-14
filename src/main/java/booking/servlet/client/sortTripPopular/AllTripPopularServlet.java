package booking.servlet.client.sortTripPopular;

import booking.Service.CitiesService;
import booking.Service.TripPopularService;
import booking.beans.Cities;
import booking.dto.TripPopular;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet(name = "allTripPopular",value = "/allTripPopular")

public class AllTripPopularServlet extends HttpServlet {
    private final TripPopularService tripPopularService = new TripPopularService();
    private final CitiesService citiesService = new CitiesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TripPopular> tripFromServer = tripPopularService.getAllTrips();
        List<Cities> cityFromServer = citiesService.getAll();

        req.setAttribute("cityFromServer",cityFromServer);
        req.setAttribute("tripFromServer",tripFromServer);
        req.getRequestDispatcher("/WEB-INF/views/homePage.jsp").forward(req,resp);
    }
}
