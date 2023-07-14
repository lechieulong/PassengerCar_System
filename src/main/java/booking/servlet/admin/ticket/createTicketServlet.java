package booking.servlet.admin.ticket;

import booking.Service.SeatTransportService;
import booking.Service.TicketService;
import booking.Service.TripsTransportService;
import booking.Utils.Protector;
import booking.Utils.Validator;
import booking.beans.SeatTransport;
import booking.beans.Ticket;
import booking.beans.TicketModifie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "createTicket",value = "/admin/ticketManager/create")
public class createTicketServlet extends HttpServlet {
    private final TicketService ticketService = new TicketService();
    private final SeatTransportService seatTransportService = new SeatTransportService();
    private final TripsTransportService tripsTransportService = new TripsTransportService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ticket ticket = new Ticket();
        SeatTransport  seatTransport = new SeatTransport();
        ticket.setTripsTransportId(Long.parseLong(req.getParameter("tripstransportId")));
        ticket.setSeatTransportId(Long.parseLong(req.getParameter("seatTransportId")));
        ticket.setUserId(Long.parseLong(req.getParameter("userId")));
        ticket.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        ticket.setTotalPrice(Double.parseDouble(req.getParameter("totalPrice")));
        ticket.setStatus(1);
        long transportId = tripsTransportService.getTransportIdByTripsTransportId(ticket.getTripsTransportId());
        seatTransport.setQuantity(seatTransportService.getQuantity(transportId));


        Map<String, List<String>> violations = new HashMap<>();
        violations.put("quantity",Validator.of(ticket.getTotalPrice())
                          .toList());

        int sumOfViolation = violations.values().stream().mapToInt(List::size).sum();

        String successMessage = "Thêm thành công";
        String errorMessage = "Thêm thất bại ";
        if (sumOfViolation == 0){
            Protector.of(()  -> {
                        seatTransport.setQuantity(seatTransport.getQuantity() - ticket.getQuantity());
                        seatTransportService.updateQuantity(seatTransport.getQuantity(),ticket.getSeatTransportId());
                        ticketService.insert(ticket);
                    })
                    .done(r -> req.setAttribute("successMessage", successMessage))
                    .fail(r -> req.setAttribute("errorMessage",errorMessage));
        }else {
            req.setAttribute("violations",violations);
            req.getRequestDispatcher("/WEB-INF/views/confirmAdminView.jsp").forward(req,resp);
        }

        req.getRequestDispatcher("/WEB-INF/views/ticketManagerView.jsp").forward(req,resp);
    }
}
