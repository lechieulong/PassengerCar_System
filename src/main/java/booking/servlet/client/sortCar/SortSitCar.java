package booking.servlet.client.sortCar;

import booking.Service.CitiesService;
import booking.Service.TransportService;
import booking.Service.TripPopularService;
import booking.beans.Cities;
import booking.beans.Transport;
import booking.dto.TripPopular;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "sortSitCar",value = "/sortSitCar")

public class SortSitCar extends HttpServlet {

    private final TransportService transportService = new TransportService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Transport>listTransport = transportService.sortSitCar();


        req.setAttribute("listTransport", listTransport);
        req.getRequestDispatcher("/WEB-INF/views/listTransportView.jsp").forward(req,resp);
    }
}
