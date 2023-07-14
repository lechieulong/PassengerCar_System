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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "TripsTransportReviewManagerServlet", value = "/admin/reviewManager")
public class TransportTripsManagerServlet extends HttpServlet {
    private final TransportTripsReviewService transportTripsReviewService = new TransportTripsReviewService();
    private final TripsTransportService tripsTransportService = new TripsTransportService();

    private final UserService userService = new UserService();

    private static final int PRODUCT_REVIEWS_PER_PAGE = 25;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int totalProductReviews = Protector.of(transportTripsReviewService::count).get(0);
        int totalPages = totalProductReviews / PRODUCT_REVIEWS_PER_PAGE +
                (totalProductReviews % PRODUCT_REVIEWS_PER_PAGE != 0 ? 1 : 0);

        String pageParam = Optional.ofNullable(req.getParameter("page")).orElse("1");
        int page = Protector.of(() -> Integer.parseInt(pageParam)).get(1);
        if (page < 1 || page > totalPages) {
            page = 1;
        }

        int offset = (page - 1) * PRODUCT_REVIEWS_PER_PAGE;

        List<TransportTripsReview> transportTripsReviews = Protector.of(() -> transportTripsReviewService.getOrderedPart(
                PRODUCT_REVIEWS_PER_PAGE, offset, "id", "DESC"
        )).get(ArrayList::new);

        for (TransportTripsReview transportTripsReview : transportTripsReviews) {
            Protector.of(() -> userService.getById(transportTripsReview.getUserId())).get(Optional::empty)
                    .ifPresent(transportTripsReview::setUser);
            Protector.of(() -> tripsTransportService.getById(transportTripsReview.getTripsTransportId())).get(Optional::empty)
                    .ifPresent(transportTripsReview::setTripsTransport);
        }

        req.setAttribute("totalPages", totalPages);
        req.setAttribute("page", page);
        req.setAttribute("productReviews", transportTripsReviews);
        req.getRequestDispatcher("/WEB-INF/views/tripsTransportReviewManagerView.jsp").forward(req, resp);
    }
}
