package booking.Service;

import booking.dao.TripsTransportByPointAndDateDAO;
import booking.dao.TripsTransportDAO;
import booking.dto.TripsTransportByPointAndDate;

import java.sql.Timestamp;
import java.util.List;

public class TripsTransportByPointAndDateService extends Service<TripsTransportByPointAndDate, TripsTransportByPointAndDateDAO> implements TripsTransportByPointAndDateDAO {
    public TripsTransportByPointAndDateService() {
        super(TripsTransportByPointAndDateDAO.class);
    }

    @Override
    public List<TripsTransportByPointAndDate> getAllTripsAndTransportByPointAndDate(long dropOffPoint, long pickUpPoint, String date) {
        return jdbi.withExtension(TripsTransportByPointAndDateDAO.class,dao -> dao.getAllTripsAndTransportByPointAndDate(dropOffPoint,pickUpPoint,date));
    }

    @Override
    public List<TripsTransportByPointAndDate> sortLIECar(long dropOffPoint, long pickUpPoint, String date) {
        return jdbi.withExtension(TripsTransportByPointAndDateDAO.class,dao -> dao.sortLIECar(dropOffPoint,pickUpPoint,date));
    }

    @Override
    public List<TripsTransportByPointAndDate> sortSITCar(long dropOffPoint, long pickUpPoint, String date) {
        return jdbi.withExtension(TripsTransportByPointAndDateDAO.class,dao -> dao.sortSITCar(dropOffPoint,pickUpPoint,date));

    }


    @Override
    public List<TripsTransportByPointAndDate> sortCheapPrice(long dropOffPoint, long pickUpPoint, String date) {
        return jdbi.withExtension(TripsTransportByPointAndDateDAO.class,dao -> dao.sortCheapPrice(dropOffPoint,pickUpPoint,date));
    }

    @Override
    public List<TripsTransportByPointAndDate> sortExpensivePrice(long dropOffPoint, long pickUpPoint, String date) {
        return jdbi.withExtension(TripsTransportByPointAndDateDAO.class,dao -> dao.sortExpensivePrice(dropOffPoint,pickUpPoint,date));
    }

    @Override
    public List<TripsTransportByPointAndDate> sortEarlyTime(long dropOffPoint, long pickUpPoint, String date) {
        return jdbi.withExtension(TripsTransportByPointAndDateDAO.class,dao -> dao.sortEarlyTime(dropOffPoint,pickUpPoint,date));
    }

    @Override
    public List<TripsTransportByPointAndDate> sortLateTime(long dropOffPoint, long pickUpPoint, String date) {
        return jdbi.withExtension(TripsTransportByPointAndDateDAO.class,dao -> dao.sortLateTime(dropOffPoint,pickUpPoint,date));
    }

    @Override
    public List<TripsTransportByPointAndDate> sortTripByCar(long dropOffPoint, long pickUpPoint, String date) {
        return jdbi.withExtension(TripsTransportByPointAndDateDAO.class,dao -> dao.sortTripByCar(dropOffPoint,pickUpPoint,date));

    }
}
