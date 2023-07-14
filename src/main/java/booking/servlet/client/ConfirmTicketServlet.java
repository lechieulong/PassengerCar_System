package booking.servlet.client;

import booking.Service.SeatTransportService;
import booking.Service.TicketModifieService;
import booking.Service.TripsTransportByPointAndDateService;
import booking.Service.TripsTransportService;
import booking.Utils.Protector;
import booking.Utils.Validator;
import booking.beans.SeatTransport;
import booking.beans.Ticket;
import booking.beans.TicketModifie;
import booking.beans.TripsTransport;
import booking.dto.TripsTransportByPointAndDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "confirmTicket",value = "/confirmTicket")

public class ConfirmTicketServlet extends HttpServlet {

    private final TicketModifieService ticketService = new TicketModifieService();
    private final TripsTransportService tripsTransportService = new TripsTransportService();

    private final TripsTransportByPointAndDateService tripsTransportByPointAndDateService = new TripsTransportByPointAndDateService();

    private final SeatTransportService seatTransportService = new SeatTransportService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TicketModifie ticket = new TicketModifie();

        ticket.setTripsTransportId(Long.parseLong(req.getParameter("tripstransportId")));
        ticket.setUserId(Long.parseLong(req.getParameter("userId")));
        ticket.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        ticket.setTotalPrice(Integer.parseInt(req.getParameter("totalPrice")));
        ticket.setStatus(1);

        Optional<TripsTransport> tripsTransport = tripsTransportService.getById(Long.parseLong(req.getParameter("tripstransportId")));

        Map<String, List<String>> violations = new HashMap<>();
        violations.put("quantity", Validator.of(ticket.getTotalPrice())
                .toList());

        int sumOfViolation = violations.values().stream().mapToInt(List::size).sum();

        String successMessage = "Thêm thành công";
        String errorMessage = "Thêm thất bại ";
        if (sumOfViolation == 0){
            Optional<TripsTransportByPointAndDate> tripsTransportFromServer = Protector.of(() -> tripsTransportByPointAndDateService.getById(ticket.getTripsTransportId())).get(Optional::empty);
            Protector.of(()  -> {
                        ticketService.insert(ticket);

                        System.out.println("empty seat " + tripsTransport.get().getEmptySeat());
                        System.out.println("Da tru " + (tripsTransport.get().getEmptySeat() - ticket.getQuantity()));
                        tripsTransportService.updateEmptySeat((tripsTransport.get().getEmptySeat() - ticket.getQuantity()),tripsTransport.get().getId());
                    })
                    .done(r -> {
                        req.setAttribute("ticket",ticket);
                        req.setAttribute("status",ticket.getStatus() == 1 ?"Chưa thanh toán - Hãy gọi cho nhà xe để xác minh chuyển khoản" : "đã thanh toán");
                        req.setAttribute("trips",tripsTransportFromServer);
                        req.setAttribute("successMessage", successMessage);
                    })
                    .fail(r ->{
                        req.setAttribute("status","Vui lòng tạo lại vé");
                        req.setAttribute("trips",tripsTransportFromServer);
                        req.setAttribute("errorMessage",errorMessage);
                    } );
        }else {
            req.setAttribute("violations",violations);
            req.getRequestDispatcher("/WEB-INF/views/confirmView.jsp").forward(req,resp);
        }
        resp.sendRedirect("ticket2");
    }
}
