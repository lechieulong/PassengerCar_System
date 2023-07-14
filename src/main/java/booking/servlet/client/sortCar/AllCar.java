package booking.servlet.client.sortCar;

import booking.Service.TransportService;
import booking.beans.Transport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet(name = "allCar",value = "/allCar")

public class AllCar extends HttpServlet {
    private final TransportService transportService = new TransportService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Transport> listTransport = transportService.getAll();

        req.setAttribute("listTransport", listTransport);
        req.getRequestDispatcher("/WEB-INF/views/listTransportView.jsp").forward(req,resp);
    }
}
