package booking.servlet.admin.transport;

import booking.Service.SeatTransportService;
import booking.Service.SeatTypeService;
import booking.Service.TransportService;
import booking.Utils.ImageUD;
import booking.Utils.Protector;
import booking.Utils.Validator;
import booking.beans.SeatTransport;
import booking.beans.SeatType;
import booking.beans.Transport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet(name = "createTransport", value = "/admin/transportManager/create")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 5, // 5 MB
        maxFileSize = 1024 * 1024 * 5, // 5 MB
        maxRequestSize = 1024 * 1024 * 10 // 10 MB
)
public class createTransportServlet extends HttpServlet {
    private final TransportService transportService = new TransportService();
    private final SeatTypeService seatTypeService = new SeatTypeService();
    private final SeatTransportService seatTransportService = new SeatTransportService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SeatType> seatTypeFromServer = seatTypeService.getAll();
        req.setAttribute("seatTypeFromServer",seatTypeFromServer);
        req.getRequestDispatcher("/WEB-INF/views/transportCreateView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Transport transport = new Transport();
        SeatTransport seatTransport = new SeatTransport();
        transport.setNameOfTransport(req.getParameter("nameOfTransport"));
        transport.setLicensePlate(req.getParameter("licensePlate").isEmpty() ? String.valueOf(12345) :req.getParameter("licensePlate"));
        transport.setDescription(req.getParameter("description").trim().isEmpty()
                ? null : req.getParameter("description"));
        transport.setTotalSeat(1);

        seatTransport.setTypeOfSeatId(Integer.parseInt(req.getParameter("seatTypeId")));
        seatTransport.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        transport.setTotalSeat(seatTransport.getQuantity());
        seatTransport.setPrice(Integer.parseInt(req.getParameter("price")));
        System.out.println(seatTransport);
        // ------------------------------- Validation Time ! ------------------------------------------------------------ //
        Map<String, List<String>> violations = new HashMap<>();
        violations.put("nameOfViolation", Validator.of(transport.getNameOfTransport())
                .isNotNullAndEmpty()
                .isAtMostOfLength(100)
                .toList());
        violations.put("description",Validator.of(transport.getDescription())
                .isAtMostOfLength(350)
                .toList());
        // -------------------------------End-------------------------------------------------------------------------- //
        int sumOfViolation = violations.values().stream().mapToInt(List::size).sum();

        String successMessage = "Thêm thành công";
        String errorMessage = "Thêm thất bại ";


        if (sumOfViolation == 0){
            ImageUD.upload(req).ifPresent(transport::setImageName);
            Protector.of(() -> {
                    seatTransport.setTransportId(transportService.insert(transport));
                    seatTransportService.insert(seatTransport);
                    })
                    .done(r -> {
                        List<SeatType> seatTypeFromServer = seatTypeService.getAll();
                        req.setAttribute("seatTypeFromServer",seatTypeFromServer);
                        req.setAttribute("successMessage", successMessage);
                    })
                    .fail(e -> {
                        req.setAttribute("transport", transport);
                        req.setAttribute("errorMessage", errorMessage);
                    });
        }else {
            req.setAttribute("transport", transport);
            req.setAttribute("violations", violations);
        }
        req.getRequestDispatcher("/WEB-INF/views/transportCreateView.jsp").forward(req,resp);
    }
}
