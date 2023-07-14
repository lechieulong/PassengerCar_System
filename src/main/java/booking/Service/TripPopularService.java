package booking.Service;

import booking.dao.TripsPopularDAO;
import booking.dto.TripPopular;

import java.util.List;

public class TripPopularService extends Service<TripPopular, TripsPopularDAO> implements TripsPopularDAO{
    public TripPopularService() {
        super(TripsPopularDAO.class);
    }

    @Override
    public List<TripPopular> getAllTrips() {
        return jdbi.withExtension(TripsPopularDAO.class,dao -> dao.getAllTrips());
    }

    @Override
    public List<TripPopular> sortMorning() {
        return jdbi.withExtension(TripsPopularDAO.class,dao -> dao.sortMorning());
    }

    @Override
    public List<TripPopular> sortAfternoon() {
        return jdbi.withExtension(TripsPopularDAO.class,dao -> dao.sortAfternoon());

    }

    @Override
    public List<TripPopular> sortNight() {
        return jdbi.withExtension(TripsPopularDAO.class,dao -> dao.sortNight());

    }
}
