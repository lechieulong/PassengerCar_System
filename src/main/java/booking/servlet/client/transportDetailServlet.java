package booking.servlet.client;

import booking.Service.TransportService;
import booking.beans.Transport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "transportDetail", value = "/client/transport/detail")

public class transportDetailServlet extends HttpServlet {
    TransportService transportService = new TransportService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Optional<Transport> transport = transportService.getById(id);
        req.setAttribute("transport",  transport.get());
        req.getRequestDispatcher("/WEB-INF/views/transportDetailClient.jsp").forward(req,resp);
    }
}
