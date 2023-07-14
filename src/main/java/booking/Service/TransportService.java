package booking.Service;

import booking.beans.Transport;
import booking.dao.TransportDAO;

import java.util.List;


public class TransportService extends Service<Transport, TransportDAO> implements TransportDAO {
    public TransportService() {
        super(TransportDAO.class);
    }
    @Override
    public void updateQuantityById(int totalSeat, long id) {
        jdbi.useExtension(TransportDAO.class, dao -> dao.updateQuantityById(totalSeat, id));
    }

    @Override
    public int count() {
        return jdbi.withExtension(TransportDAO.class,TransportDAO::count);
    }

    @Override
    public List<Transport> sortSitCar() {
       return jdbi.withExtension(TransportDAO.class, dao -> dao.sortSitCar());
    }

    @Override
    public List<Transport> sortLieCar() {
        return jdbi.withExtension(TransportDAO.class, dao -> dao.sortLieCar());
    }


}
