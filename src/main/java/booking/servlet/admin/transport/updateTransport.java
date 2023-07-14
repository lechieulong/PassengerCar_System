package booking.servlet.admin.transport;

import booking.Service.TransportService;
import booking.Utils.ImageUD;
import booking.Utils.Validator;
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
import java.util.Optional;

@WebServlet(name = "updateTransport",value = "/admin/transportManager/update")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 5, // 5 MB
        maxFileSize = 1024 * 1024 * 5, // 5 MB
        maxRequestSize = 1024 * 1024 * 10 // 10 MB
)
public class updateTransport extends HttpServlet {
    private final TransportService transportService = new TransportService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Optional<Transport> transportFromServer = transportService.getById(id);
        if (transportFromServer.isPresent()){
            req.setAttribute("transport",transportFromServer.get());
            req.getRequestDispatcher("/WEB-INF/views/transportUpdateView.jsp").forward(req, resp);
        }else {
            resp.sendRedirect(req.getContextPath() + "/admin/transportManager");
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Transport transport = new Transport();
        transport.setId(Long.parseLong(req.getParameter("id")));
        transport.setNameOfTransport(req.getParameter("nameOfTransport"));
        transport.setLicensePlate(req.getParameter("licensePlate"));
        transport.setDescription(req.getParameter("description").trim().isEmpty()?null:req.getParameter("description"));
        transport.setTotalSeat(Integer.parseInt(req.getParameter("slot")));
        transport.setImageName(req.getParameter("imageName").trim().isEmpty()?null:req.getParameter("imageName"));
        String deleteImage = req.getParameter("deleteImage");
        Map<String, List<String>> violations = new HashMap<>();
        violations.put("userName", Validator.of(transport.getNameOfTransport())
                .isNotNullAndEmpty()
                .isNotBlankAtBothEnds()
                .isAtMostOfLength(100)
                .toList());
        violations.put("licensePlate", Validator.of(transport.getLicensePlate())
                .isNotEmpty()
                .toList());
        violations.put("descriptionViolations", Validator.of(transport.getDescription())
                .isAtMostOfLength(350)
                .toList());
        // Đếm lỗi của list trong map
        int sumOfViolation = violations.values().stream().mapToInt(List::size).sum();
        String successMessage = "Thêm thành công";
        String errorMessage = "Thêm thất bại ";
        // Xử lí ảnh
        if (sumOfViolation == 0){
          if (transport.getImageName() != null){
              String currentImage = transport.getImageName();
              if (deleteImage != null){
                  ImageUD.delete(currentImage);
                  transport.setImageName(null);
              }
              ImageUD.upload(req).ifPresent(image ->{
                  ImageUD.delete(currentImage);
                  transport.setImageName(image);
              });
          }else {
              ImageUD.upload(req).ifPresent(transport::setImageName);
          }
            try {
                transportService.update(transport);
                req.setAttribute("successMessage", successMessage);
            }
            catch(Exception e) {
                req.setAttribute("transport", transport);
                req.setAttribute("errorMessage", errorMessage);
            }
        }else {
            req.setAttribute("transport", transport);
            req.setAttribute("violations", violations);
            req.setAttribute("deleteImage", deleteImage);
        }

        req.getRequestDispatcher("/WEB-INF/views/transportUpdateView.jsp").forward(req, resp);

    }
}
