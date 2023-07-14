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
import java.util.Optional;


@WebServlet(name = "detailTicket",value = "/client/detailTicket")
public class detailTicket extends HttpServlet {

    private TicketModifieService ticketModifieService = new TicketModifieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id =  Long.parseLong(req.getParameter("id"));
      Optional<TicketModifie> ticket =  ticketModifieService.getTicketByID(id);
        HttpSession session=req.getSession();
        User u = (User) session.getAttribute("currentUser");
        req.setAttribute("user", u);
        req.setAttribute("ticket", ticket.get());
        req.getRequestDispatcher("/WEB-INF/views/detailTicket.jsp").forward(req,resp);
    }
}
