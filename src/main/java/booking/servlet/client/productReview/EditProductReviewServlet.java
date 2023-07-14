package booking.servlet.client.productReview;

import booking.Service.TransportTripsReviewService;
import booking.Service.TripsTransportService;
import booking.Service.UserService;
import booking.Utils.Protector;
import booking.Utils.Validator;
import booking.beans.TransportTripsReview;
import booking.beans.TripsTransport;
import booking.beans.User;
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

@WebServlet(name = "EditProductReviewServlet", value = "/editProductReview")
public class EditProductReviewServlet extends HttpServlet {
    private final TransportTripsReviewService transportTripsReviewService = new TransportTripsReviewService();
    private final TripsTransportService tripsTransportService = new TripsTransportService();

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Protector.of(() -> Long.parseLong(request.getParameter("id"))).get(0L);
        Optional<TransportTripsReview> tripsTransportFromServer = Protector.of(() -> transportTripsReviewService.getById(id))
                .get(Optional::empty);

        if (tripsTransportFromServer.isPresent()) {
            TransportTripsReview transportTripsReview = tripsTransportFromServer.get();
            Protector.of(() -> userService.getById(transportTripsReview.getUserId())).get(Optional::empty)
                    .ifPresent(transportTripsReview::setUser);
            Protector.of(() -> tripsTransportService.getById(transportTripsReview.getTripsTransportId())).get(Optional::empty)
                    .ifPresent(transportTripsReview::setTripsTransport);
            boolean isExactUser = Optional.ofNullable((User) request.getSession().getAttribute("currentUser"))
                    .map(u -> u.getId() == transportTripsReview.getUserId())
                    .orElse(false);
            if (isExactUser) {
                request.setAttribute("productReview", transportTripsReview);
                request.getRequestDispatcher("/WEB-INF/views/editProductReviewView.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Protector.of(() -> Long.parseLong(request.getParameter("id"))).get(0L);
        Optional<TransportTripsReview> productReviewFromServer = Protector.of(() -> transportTripsReviewService.getById(id))
                .get(Optional::empty);

        TransportTripsReview productReview = productReviewFromServer.orElseGet(TransportTripsReview::new);
        productReview.setRatingScore(Protector.of(() -> Integer.parseInt(request.getParameter("ratingScore"))).get(0));
        productReview.setContent(request.getParameter("content"));
        Protector.of(() -> userService.getById(productReview.getUserId())).get(Optional::empty)
                .ifPresent(productReview::setUser);
        Protector.of(() -> tripsTransportService.getById(productReview.getTripsTransportId())).get(Optional::empty)
                .ifPresent(productReview::setTripsTransport);

        Map<String, List<String>> violations = new HashMap<>();
        violations.put("ratingScoreViolations", Validator.of(productReview.getRatingScore())
                .isNotNull()
                .toList());
        violations.put("contentViolations", Validator.of(productReview.getContent())
                .isNotNullAndEmpty()
                .isAtLeastOfLength(10)
                .toList());

        int sumOfViolations = violations.values().stream().mapToInt(List::size).sum();
        String successMessage = "Đã sửa đánh giá thành công!";
        String errorMessage = "Đã có lỗi truy vấn!";

        if (sumOfViolations == 0) {
            Protector.of(() -> transportTripsReviewService.update(productReview))
                    .done(r -> request.setAttribute("successMessage", successMessage))
                    .fail(e -> request.setAttribute("errorMessage", errorMessage));
        } else {
            request.setAttribute("violations", violations);
        }

        request.setAttribute("productReview", productReview);
        request.getRequestDispatcher("/WEB-INF/views/editProductReviewView.jsp").forward(request, response);
    }
}
