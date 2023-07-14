package booking.servlet.admin.transportTripsReview;

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
@WebServlet(name = "UpdateTripsTransportReviewServlet", value = "/admin/reviewManager/update")
public class UpdateTransportReviewServlet extends HttpServlet {
    private final TransportTripsReviewService transportTripsReviewService = new TransportTripsReviewService();
    private final UserService userService = new UserService();
    private final TripsTransportService tripsTransportService = new TripsTransportService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Protector.of(() -> Long.parseLong(req.getParameter("id"))).get(0L);
        String action = req.getParameter("action");

        String errorMessage = "Đã có lỗi truy vấn!";

        if ("HIDE".equals(action)) {
            String successMessage = String.format("Đã ẩn đánh giá #%s thành công!", id);
            Protector.of(() -> transportTripsReviewService.hide(id))
                    .done(r -> req.getSession().setAttribute("successMessage", successMessage))
                    .fail(e -> req.getSession().setAttribute("errorMessage", errorMessage));
        }

        if ("SHOW".equals(action)) {
            String successMessage = String.format("Đã hiện đánh giá #%s thành công!", id);
            Protector.of(() -> transportTripsReviewService.show(id))
                    .done(r -> req.getSession().setAttribute("successMessage", successMessage))
                    .fail(e -> req.getSession().setAttribute("errorMessage", errorMessage));
        }

        resp.sendRedirect(req.getContextPath() + "/admin/reviewManager");
    }
}
