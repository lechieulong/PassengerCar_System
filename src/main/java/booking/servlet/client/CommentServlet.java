package booking.servlet.client;

import booking.Service.*;
import booking.beans.*;
import booking.dto.CommentTrip;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "comment",value = "/comment")

public class CommentServlet  extends HttpServlet {
    private final CommentService commentService = new CommentService();
    private final CommentTwoService commentTwoService = new CommentTwoService();
    private final TripsTransportService tripsTransportService = new TripsTransportService();
    private final TransportService transportService = new TransportService();
    private final AnswerCommentService answerCommentService = new AnswerCommentService();
    private TicketModifieService ticketModifieService = new TicketModifieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = Long.parseLong(req.getParameter("id"));
        Optional<TicketModifie> ticketModifie = ticketModifieService.getById(id);
        List<CommentTrip> listComment = commentService.getCommentByTrip(ticketModifie.get().getTripsTransportId());

        Optional<TripsTransport> trip = tripsTransportService.getById(ticketModifie.get().getTripsTransportId());
        Optional<Transport> transport = transportService.getById(trip.get().getTransportId());

        HttpSession session=req.getSession();
        User u = (User) session.getAttribute("currentUser");

        req.setAttribute("user", u);
        req.setAttribute("listComment",listComment);
        req.setAttribute("transport",transport.get());
        req.setAttribute("ticketId",ticketModifie.get().getId());
        req.getRequestDispatcher("/WEB-INF/views/CommentTrip.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Comment comment = new Comment();

        comment.setTicketId(Long.parseLong(req.getParameter("ticketId")));
        comment.setContent(req.getParameter("content"));
        comment.setRatingScore(Integer.parseInt(req.getParameter("ratingScore")));
        LocalDateTime dateNow =LocalDateTime.now();
        comment.setCreateAt(dateNow);
        comment.setUpdateAt(dateNow);

        commentTwoService.insert(comment);
        Optional<TicketModifie> tic = ticketModifieService.getTicketByID(Long.parseLong(req.getParameter("ticketId")));

        List<CommentTrip> listComment = commentService.getCommentByTrip(tic.get().getTripsTransportId());

        HttpSession session=req.getSession();
        User u = (User) session.getAttribute("currentUser");
        Optional<TripsTransport> trip = tripsTransportService.getById(tic.get().getTripsTransportId());
        Optional<Transport> transport = transportService.getById(trip.get().getTransportId());

        req.setAttribute("transport",transport.get());
        req.setAttribute("listComment",listComment);
        req.setAttribute("user", u);
        req.setAttribute("ticketId",Long.parseLong(req.getParameter("ticketId")));
//        req.setAttribute("answerComment",answerComment);
        req.getRequestDispatcher("/WEB-INF/views/CommentTrip.jsp").forward(req,resp);
    }
}
