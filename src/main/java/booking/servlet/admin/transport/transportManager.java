package booking.servlet.admin.transport;

import booking.Service.TransportService;
import booking.beans.Transport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "transportManager", value = "/admin/transportManager")
public class transportManager extends HttpServlet {
    private final TransportService transportService = new TransportService();
    private static final int TRANSPORT_PER_PAGE = 5;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int totalTransport = transportService.count();
        int totalPages = totalTransport / TRANSPORT_PER_PAGE + (totalTransport % TRANSPORT_PER_PAGE != 0 ? 1 : 0);

        String pageParam = Optional.ofNullable(req.getParameter("page")).orElse("1");
        int page = Integer.parseInt(pageParam);
        if (page < 1 || page > totalPages) page = 1;


        int offset = (page - 1) * TRANSPORT_PER_PAGE;
        List<Transport> transportList = transportService.getOrderedPart(
                TRANSPORT_PER_PAGE, offset, "id", "DESC"
        );
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("page", page);
        req.setAttribute("transport", transportList);
        req.getRequestDispatcher("/WEB-INF/views/transportManagerView.jsp").forward(req,resp);
    }


}
