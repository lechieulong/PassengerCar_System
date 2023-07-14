package booking.Service;

import booking.dao.SeatTransportDAO;
import booking.dao.TripsTransportWithRoutesDAO;
import booking.dto.TripsTransportWithRoutes;

import java.util.List;
import java.util.Optional;

public class TripsTransportWithRoutesService extends Service<TripsTransportWithRoutes, TripsTransportWithRoutesDAO> implements TripsTransportWithRoutesDAO{
    public TripsTransportWithRoutesService() {
        super(TripsTransportWithRoutesDAO.class);
    }



    @Override
    public List<TripsTransportWithRoutes> GetAllTripsTransportWithRoutes() {
        return jdbi.withExtension(TripsTransportWithRoutesDAO.class, TripsTransportWithRoutesDAO::GetAllTripsTransportWithRoutes);
    }



    @Override
    public int count() {
        return jdbi.withExtension(TripsTransportWithRoutesDAO.class,TripsTransportWithRoutesDAO::count) ;
    }
}
