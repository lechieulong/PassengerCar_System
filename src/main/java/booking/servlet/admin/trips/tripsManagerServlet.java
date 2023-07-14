package booking.servlet.admin.trips;

import booking.Service.TripsTransportWithRoutesService;
import booking.beans.TripsTransport;
import booking.dao.TripsTransportWithRoutesDAO;
import booking.dto.TripsTransportWithRoutes;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "tripsManager",value = "/admin/tripsManager")
public class tripsManagerServlet extends HttpServlet {
    private final TripsTransportWithRoutesService tripsTransportWithRoutesService = new TripsTransportWithRoutesService();
    private static final int TRIPS_TRANSPORT_PER_PAGE = 5;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int totalTransport = tripsTransportWithRoutesService.count();
        int totalPages = totalTransport / TRIPS_TRANSPORT_PER_PAGE + (totalTransport % TRIPS_TRANSPORT_PER_PAGE != 0 ? 1 : 0);

        String pageParam = Optional.ofNullable(req.getParameter("page")).orElse("1");
        int page = Integer.parseInt(pageParam);
        if (page < 1 || page > totalPages) {
            page = 1;
        }

        int offset = (page - 1) * TRIPS_TRANSPORT_PER_PAGE;
        List<TripsTransportWithRoutes> tripFromServer = tripsTransportWithRoutesService.getOrderedPart(
                TRIPS_TRANSPORT_PER_PAGE, offset, "id", "DESC"
        );
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("page", page);
        req.setAttribute("tripFromServer", tripFromServer);
        req.getRequestDispatcher("/WEB-INF/views/tripsManagerView.jsp").forward(req, resp);
    }
}
