package booking.servlet.client;

import booking.Service.TicketService;
import booking.Service.TripsTransportByPointAndDateService;
import booking.Service.TripsTransportService;
import booking.Service.UserService;
import booking.beans.TripsTransport;
import booking.beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ticket",value = "/ticket")

public class Ticket extends HttpServlet {

    TicketService ticketService = new TicketService();
    UserService userService = new UserService();
    TripsTransportService tripsTransportService = new TripsTransportService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int quantity = Integer.parseInt((String) session.getAttribute("quantity")) ;
        long tripID = Long.parseLong((String) session.getAttribute("tripID"));
        String ticketID = (String) session.getAttribute("ticketID");
        User u = (User) session.getAttribute("currentUser");


        if(ticketID == null) {
            ticketService.updateStatus();
        }else{
            ticketService.updateStatusByID(Long.parseLong(ticketID));
        }
        // accumulated point when by ticket
        userService.addAccumulatedPoint(quantity,u.getId() );

        Optional<TripsTransport> trip  = tripsTransportService.getById(tripID);
        tripsTransportService.updateEmptySeat(trip.get().getEmptySeat() - quantity,tripID );
        req.setAttribute("vnp_SecureHash", req.getParameter("vnp_SecureHash"));
        req.setAttribute("vnp_SecureHashType", req.getParameter("vnp_SecureHashType"));
        req.setAttribute("vnp_TxnRef", req.getParameter("vnp_TxnRef"));
        req.setAttribute("vnp_Amount", req.getParameter("vnp_Amount"));
        req.setAttribute("vnp_OrderInfo", req.getParameter("vnp_OrderInfo"));
        req.setAttribute("vnp_ResponseCode", req.getParameter("vnp_ResponseCode"));
        req.setAttribute("vnp_TransactionNo", req.getParameter("vnp_TransactionNo"));
        req.setAttribute("vnp_BankCode", req.getParameter("vnp_BankCode"));
        req.setAttribute("vnp_PayDate", req.getParameter("vnp_PayDate"));
        req.setAttribute("vnp_TransactionStatus", req.getParameter("vnp_TransactionStatus"));
        req.getRequestDispatcher("/WEB-INF/views/vnpay_return.jsp").forward(req,resp);
    }
}
