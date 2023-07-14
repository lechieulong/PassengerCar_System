package booking.servlet.admin.transport;

import booking.Service.TransportService;
import booking.beans.Transport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;
@WebServlet(name = "detailTransport", value = "/admin/transportManager/detail")
public class detailTransport extends HttpServlet {
    private final TransportService transportService= new TransportService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Optional<Transport> transportFromServer = transportService.getById(id);
        if (transportFromServer.isPresent()){
            req.setAttribute("transport",transportFromServer.get());
            req.getRequestDispatcher("/WEB-INF/views/transportDetailView.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath() + "/admin/transportManager");
        }

    }


}
