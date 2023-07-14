package booking.servlet.client.sortTripPopular;

import booking.Service.CitiesService;
import booking.Service.TripPopularService;
import booking.Service.TripsTransportByPointAndDateService;
import booking.beans.Cities;
import booking.beans.User;
import booking.dto.TripPopular;
import booking.dto.TripsTransportByPointAndDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "sortAfternoon",value = "/sortAfternoon")

public class SortAfternoonServlet extends HttpServlet {
    private final TripPopularService tripPopularService = new TripPopularService();
    private final CitiesService citiesService = new CitiesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TripPopular> tripFromServer = tripPopularService.sortAfternoon();
        List<Cities> cityFromServer = citiesService.getAll();

        req.setAttribute("cityFromServer",cityFromServer);
        req.setAttribute("tripFromServer",tripFromServer);
        req.getRequestDispatcher("/WEB-INF/views/homePage.jsp").forward(req,resp);
    }
}
