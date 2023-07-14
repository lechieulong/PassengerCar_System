package booking.servlet.client;

import booking.Service.*;
import booking.beans.Cities;
import booking.beans.Comment;
import booking.beans.Rating;
import booking.beans.Trips;
import booking.dto.TripPopular;
import booking.dto.TripsTransportByPointAndDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@WebServlet(name = "homePage", value = "/homePage")
public class HomeServlet extends HttpServlet {
    private final TripPopularService tripPopularService = new TripPopularService();
    private final CitiesService citiesService = new CitiesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cities> cityFromServer = citiesService.getAll();
        List<TripPopular> tripFromServer = tripPopularService.getAllTrips();

//        List<Comment> listComment = commentTwoService.getAll();

//        HashMap<Integer , List<Rating>> hash= new HashMap<>();
//        HashMap<Long, Integer> hashTypeRate = new HashMap<>();
//        List<Rating> listRate = new ArrayList<>();
//
//        for(TripPopular trip : tripFromServer){
//            System.out.println("trip " + trip.getTripsTransportId());
//            for(Comment comment : listComment){
//                if(trip.getTripsTransportId() == comment.getTripstransportId()){
//                    // xử lí array here
//                    if(!hashTypeRate.containsKey(trip.getTripsTransportId()) ){
//                        hashTypeRate.put(trip.getTripsTransportId(),1);
//                    }else {
//                        hashTypeRate.put(trip.getTripsTransportId(),hashTypeRate.get(comment.getRatingScore()) +1 );
//                    }
//                }
//
//            }
//        }

        //        listRate.add(new Rating(comment.getRatingScore(),));
//        hash.put(trip.getTripsTransportId(), )

        

        req.setAttribute("tripFromServer",tripFromServer);
        req.setAttribute("cityFromServer",cityFromServer);
        req.getRequestDispatcher("/WEB-INF/views/homePage.jsp").forward(req,resp);
    }

}
