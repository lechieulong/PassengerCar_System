package booking.servlet.client;

import booking.Service.TicketModifieService;
import booking.Service.TripsTransportByPointAndDateService;
import booking.beans.TicketModifie;
import booking.beans.User;
import booking.dto.TripsTransportByPointAndDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "payment2",value = "/payment2")

public class Payment2Servlet extends HttpServlet {

    private TicketModifieService ticketModifieService = new TicketModifieService();
    private TripsTransportByPointAndDateService tripsTransportByPointAndDateService = new TripsTransportByPointAndDateService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        Optional<TicketModifie> ticket = ticketModifieService.getById(id);
        HttpSession session = req.getSession();
        String quantity = String.valueOf(ticket.get().getQuantity());
        String tripID = String.valueOf(ticket.get().getTripsTransportId());
        session.setAttribute("quantity", quantity);
        session.setAttribute("tripID", tripID);
        session.setAttribute("ticketID", req.getParameter("id"));
        User u = (User) session.getAttribute("currentUser");

        Optional<TripsTransportByPointAndDate> trips = tripsTransportByPointAndDateService.getById(ticket.get().getTripsTransportId());

        req.setAttribute("user", u);
        req.setAttribute("trips", trips.get());
        req.setAttribute("quantity",ticket.get().getQuantity());
        req.setAttribute("totalPrice",ticket.get().getTotalPrice() );
        req.getRequestDispatcher("/WEB-INF/views/payment.jsp").forward(req,resp);
    }
}
