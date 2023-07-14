package booking.servlet.client.Sort;

import booking.Service.TripsTransportByPointAndDateService;
import booking.beans.User;
import booking.dto.TripsTransportByPointAndDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "sortExpensivePrice",value = "/sortExpensivePrice")

public class SortExpensivePriceServlet extends HttpServlet {

    private final TripsTransportByPointAndDateService tripsTransportByPointAndDateService = new TripsTransportByPointAndDateService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String pickUpPoint = (String) session.getAttribute("pickUpPoint");
        String dropOffPoint = (String) session.getAttribute("dropOffPoint");
        String date = (String) session.getAttribute("date");

        List<TripsTransportByPointAndDate> tripsTransportFromServerWithCondition = tripsTransportByPointAndDateService.sortExpensivePrice(Long.parseLong(dropOffPoint),Long.parseLong(pickUpPoint),date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //date now
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(format);
        LocalDateTime datePresent = LocalDateTime.parse(formatDateTime, formatter);

        List<TripsTransportByPointAndDate> tripsTransportFromServer = new ArrayList<>();
        // Get trip From now to future
        for(TripsTransportByPointAndDate trip : tripsTransportFromServerWithCondition){
            LocalDateTime dateConvert = LocalDateTime.parse(trip.getDepartTime(), formatter);
            if(dateConvert.isEqual(datePresent) || dateConvert.isAfter(datePresent) ){
                tripsTransportFromServer.add(trip);
            }
        }


        session.setAttribute("pickUpPoint", pickUpPoint);
        session.setAttribute("dropOffPoint", dropOffPoint);
        session.setAttribute("date", date);

        User u = (User) session.getAttribute("currentUser");
        req.setAttribute("user", u);
        req.setAttribute("tripsTransportFromServer",tripsTransportFromServer);
        req.getRequestDispatcher("/WEB-INF/views/listTripViews.jsp").forward(req,resp);
    }
}
