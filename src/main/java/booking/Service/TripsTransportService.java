package booking.Service;

import booking.beans.TripsTransport;
import booking.dao.SeatTransportDAO;
import booking.dao.TransportDAO;
import booking.dao.TripsTransportDAO;

import java.util.Optional;

public class TripsTransportService extends Service<TripsTransport, TripsTransportDAO> implements TripsTransportDAO {
    public TripsTransportService() {
        super(TripsTransportDAO.class);
    }

    @Override
    public long getTransportIdByTripsTransportId(long id) {
        return jdbi.withExtension(TripsTransportDAO.class,dao ->dao.getTransportIdByTripsTransportId(id));
    }

    @Override
    public int count() {
        return jdbi.withExtension(TripsTransportDAO.class,TripsTransportDAO::count);
    }

    @Override
    public void updateEmptySeat(int emptySeat, long id) {
        jdbi.useExtension(TripsTransportDAO.class, dao -> dao.updateEmptySeat(emptySeat,id));
    }
}
