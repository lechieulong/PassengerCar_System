package booking.Service;

import booking.beans.Trips;
import booking.dao.TripsDAO;
import booking.dao.TripsTransportDAO;

import java.util.Optional;

public class TripsService extends Service<Trips, TripsDAO> implements TripsDAO{
    public TripsService() {
        super(TripsDAO.class);
    }

    @Override
    public Optional<Trips> getRouteName() {
        return Optional.empty();
    }

    @Override
    public int count() {
        return jdbi.withExtension(TripsDAO.class,TripsDAO::count);
    }
}
