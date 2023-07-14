package booking.servlet.client;

import booking.Service.TicketModifieService;
import booking.beans.TicketModifie;
import booking.beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ticket2",value = "/ticket2")

public class TicketServlet2 extends HttpServlet {
    TicketModifieService ticketModifieService = new TicketModifieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        User u = (User) session.getAttribute("currentUser");
        List<TicketModifie> listTicket = ticketModifieService.getAllTicket(u.getId());

        req.setAttribute("listTicket", listTicket);
        req.getRequestDispatcher("/WEB-INF/views/ticketsView.jsp").forward(req,resp);
    }
}
