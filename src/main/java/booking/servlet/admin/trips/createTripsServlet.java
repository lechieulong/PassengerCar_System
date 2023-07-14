package booking.servlet.admin.trips;

import booking.Service.RouteService;
import booking.Service.TransportService;
import booking.Service.TripsService;
import booking.Service.TripsTransportService;
import booking.Utils.ImageUD;
import booking.Utils.Protector;
import booking.Utils.Validator;
import booking.beans.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Optional;


@WebServlet(name ="tripsCreate",value = "/admin/tripsManager/create")
public class createTripsServlet extends HttpServlet {
    private final TripsService tripsService = new TripsService();
    private final TripsTransportService tripsTransportService = new TripsTransportService();
    private final TransportService transportService = new TransportService();
    private final RouteService routeService = new RouteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Route> routesFromSerVer = routeService.getAll();
        List<Transport> transportsFromServer = transportService.getAll();
        req.setAttribute("routes",routesFromSerVer);
        req.setAttribute("transports",transportsFromServer);
        req.getRequestDispatcher("/WEB-INF/views/tripsCreateView.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Trips trips = new Trips();

        long transportId = Long.parseLong(req.getParameter("transportId"));

        trips.setRoutesId(Long.parseLong(req.getParameter("routesId")));
//        String hourSelect = req.getParameter("hourSelect");
//        String minuteSelect = req.getParameter("minuteSelect");
//        hourSelect = hourSelect.length() == 1 ? "0" + hourSelect : hourSelect;
//        minuteSelect = minuteSelect.length() == 1 ? "0" + minuteSelect : minuteSelect;
//        String timeString = hourSelect + ":" + minuteSelect;
//        LocalTime selectedTime = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
//        LocalDateTime selectedDateTime = LocalDateTime.of(LocalDate.now(), selectedTime);
//        Timestamp timestamp = Timestamp.valueOf(selectedDateTime);

//        trips.setTimeOfTrips(timestamp);

        TripsTransport tripsTransport = new TripsTransport();
        tripsTransport.setTransportId(transportId);

        Optional<Transport> transportFromServer = transportService.getById(transportId);
        tripsTransport.setEmptySeat(transportFromServer.get().getTotalSeat());

        String datetimeInput = req.getParameter("datetimeInput");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime selectedDateTime2 = LocalDateTime.parse(datetimeInput, formatter);
        Timestamp timestamp2 = Timestamp.valueOf(selectedDateTime2);

        tripsTransport.setDepartTime(timestamp2);

        String successMessage = "Thêm thành công";
        String errorMessage = "Thêm thất bại";
        Protector.of(() -> {

                    tripsTransport.setTripsId(tripsService.insert(trips));

                    tripsTransportService.insert(tripsTransport);
                })
                .done(r -> req.setAttribute("successMessage", successMessage))
                .fail(e -> req.setAttribute("errorMessage", errorMessage));
        req.getRequestDispatcher("/WEB-INF/views/tripsCreateView.jsp").forward(req, resp);
    }

}
