package booking.servlet.admin.ticket;


import booking.Service.TicketService;
import booking.Service.TripsTransportByPointAndDateService;
import booking.Service.UserService;
import booking.Utils.Protector;
import booking.beans.Ticket;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ticketManager",value = "/admin/ticketManager")
public class ticketManagerServlet extends HttpServlet {
    private final TicketService ticketService = new TicketService();
    private final UserService userService = new UserService();
    private final TripsTransportByPointAndDateService tripsTransportByPointAndDateService = new TripsTransportByPointAndDateService();
    private static final int TICKETS_PER_PAGE = 10;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int totalTicket = Protector.of(ticketService::count).get(0);
        int totalPages = totalTicket / TICKETS_PER_PAGE + (totalTicket % TICKETS_PER_PAGE != 0 ? 1 : 0);

        String pageParam = Optional.ofNullable(req.getParameter("page")).orElse("1");
        int page = Protector.of(() -> Integer.parseInt(pageParam)).get(1);
        if (page < 1 || page > totalPages) {
            page = 1;
        }

        int offset = (page - 1) * TICKETS_PER_PAGE;

        List<Ticket> tickets = Protector.of(() -> ticketService.getOrderedPart(
                TICKETS_PER_PAGE, offset, "id", "DESC"
        )).get(ArrayList::new);

        for (Ticket ticket :tickets) {
            Protector.of(()->userService.getById(ticket.getUserId())).get(Optional::empty).ifPresent(ticket::setUser);
            Protector.of(()->tripsTransportByPointAndDateService.getById(ticket.getTripsTransportId())).get(Optional::empty).ifPresent(ticket::setTripsTransportByPointAndDate);
        }
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("page", page);
        req.setAttribute("tickets", tickets);
        req.getRequestDispatcher("/WEB-INF/views/ticketManagerView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
