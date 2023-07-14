package booking.servlet.admin.transportTripsReview;

import booking.Service.TransportTripsReviewService;
import booking.Service.TripsTransportService;
import booking.Service.UserService;
import booking.Utils.Protector;
import booking.beans.TransportTripsReview;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "transportTripsDetailServlet", value = "/admin/reviewManager/detail")
public class transportTripsReviewDetailServlet extends HttpServlet {
    private final TransportTripsReviewService transportTripsReviewService = new TransportTripsReviewService();
    private final UserService userService = new UserService();
    private final TripsTransportService tripsTransportService = new TripsTransportService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Protector.of(() -> Long.parseLong(req.getParameter("id"))).get(0L);
        Optional<TransportTripsReview> productReviewFromServer = Protector.of(() -> transportTripsReviewService.getById(id))
                .get(Optional::empty);

        if (productReviewFromServer.isPresent()) {
            TransportTripsReview transportTripsReview = productReviewFromServer.get();
            transportTripsReview.setContent(transportTripsReview.getContent());
            Protector.of(() -> userService.getById(transportTripsReview.getUserId())).get(Optional::empty)
                    .ifPresent(transportTripsReview::setUser);
            Protector.of(() -> tripsTransportService.getById(transportTripsReview.getTripsTransportId())).get(Optional::empty)
                    .ifPresent(transportTripsReview::setTripsTransport);
            req.setAttribute("productReview", transportTripsReview);
            req.getRequestDispatcher("/WEB-INF/views/transportTripsReviewDetailView.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/admin/reviewManager");
        }

}}
