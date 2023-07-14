package booking.servlet.client.productReview;

import booking.Service.TransportTripsReviewService;
import booking.Service.TripsTransportService;
import booking.Service.UserService;
import booking.Utils.Protector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteProductReviewServlet", value = "/deleteProductReview")
public class DeleteProductReviewServlet extends HttpServlet {
    private final TransportTripsReviewService transportTripsReviewService = new TransportTripsReviewService();
    private final TripsTransportService tripsTransportService = new TripsTransportService();

    private final UserService userService = new UserService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long productReviewId = Protector.of(() -> Long.parseLong(request.getParameter("productReviewId"))).get(0L);
        String tripsTransportId = request.getParameter("tripsTransportId");

        String successMessage = "Đã xóa đánh giá thành công!";
        String errorDeleteReviewMessage = "Đã có lỗi truy vấn!";

        Protector.of(() -> transportTripsReviewService.delete(productReviewId))
                .done(r -> request.getSession().setAttribute("successMessage", successMessage))
                .fail(e -> request.getSession().setAttribute("errorDeleteReviewMessage", errorDeleteReviewMessage));

        response.sendRedirect(request.getContextPath() + "/transport?id=" + tripsTransportId + "#review");
    }
}
