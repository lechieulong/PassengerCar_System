package booking.servlet.admin.transport;

import booking.Service.TransportService;
import booking.Utils.ImageUD;
import booking.beans.Transport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "deleteTransport", value = "/admin/transportManager/delete")
public class deleteTransportServlet extends HttpServlet {
    private final TransportService transportService= new TransportService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Optional<Transport> transportFromServer = transportService.getById(id);

        if(transportFromServer.isPresent()){
            String successMessage = String.format("Xóa phương tiện #%s thành công!", id);
            String errorMessage = String.format("Xóa phương tiện  #%s thất bại!", id);
            try {
                transportService.delete(id);
                Optional.ofNullable(transportFromServer.get().getImageName()).ifPresent(ImageUD::delete);
                req.getSession().setAttribute("successMessage", successMessage);
            }
            catch(Exception e) {
                req.getSession().setAttribute("errorMessage", errorMessage);
            }

        }


        resp.sendRedirect(req.getContextPath()+"/admin/transportManager");
    }


}
