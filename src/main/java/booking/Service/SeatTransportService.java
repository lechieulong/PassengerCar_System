package booking.Service;

import booking.beans.SeatTransport;
import booking.dao.SeatTransportDAO;
import booking.dao.SeatTypeDAO;
import booking.dao.TripsTransportWithRoutesDAO;
import booking.dto.TripsTransportWithRoutes;

import java.util.Optional;

public class SeatTransportService extends Service<SeatTransport, SeatTransportDAO> implements SeatTransportDAO{
    public SeatTransportService() {
        super(SeatTransportDAO.class);
    }
    @Override
    public Optional<SeatTransport> getQuantityAndPriceByTrips(long id) {
        return jdbi.withExtension(SeatTransportDAO.class, dao -> dao.getQuantityAndPriceByTrips(id));
    }

    @Override
    public void updateQuantity(int quantity,long id) {
         jdbi.useExtension(SeatTransportDAO.class,dao -> dao.updateQuantity(quantity,id));
    }

    @Override
    public Integer getQuantity(long id) {
        return jdbi.withExtension(SeatTransportDAO.class,dao -> dao.getQuantity(id));
    }


}
