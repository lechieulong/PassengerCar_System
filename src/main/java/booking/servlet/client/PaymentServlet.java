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

@WebServlet(name = "payment",value = "/payment")

public class PaymentServlet extends HttpServlet {

    TicketModifieService ticketModifieService = new TicketModifieService();
    TripsTransportByPointAndDateService tripsTransportByPointAndDateService = new TripsTransportByPointAndDateService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TicketModifie ticketModifie = new TicketModifie();
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("currentUser");
        ticketModifie.setUserId(u.getId());
        ticketModifie.setTripsTransportId(Long.parseLong(req.getParameter("tripsTransportId")));
        ticketModifie.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        ticketModifie.setTotalPrice(Integer.parseInt(req.getParameter("totalPrice")));
        ticketModifie.setStatus(1);
        ticketModifieService.insert(ticketModifie);

        session.setAttribute("quantity", req.getParameter("quantity"));
        session.setAttribute("tripID", req.getParameter("tripsTransportId"));

        Optional<TripsTransportByPointAndDate> trips = tripsTransportByPointAndDateService.getById(Long.parseLong(req.getParameter("tripsTransportId")));
        req.setAttribute("user", u);
        req.setAttribute("trips", trips.get());
        req.setAttribute("quantity", req.getParameter("quantity"));
        req.setAttribute("totalPrice", req.getParameter("totalPrice"));
        req.getRequestDispatcher("/WEB-INF/views/payment.jsp").forward(req,resp);
    }
}
