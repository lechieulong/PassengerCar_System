package booking.Service;

import booking.beans.SeatType;
import booking.dao.SeatTypeDAO;


public class SeatTypeService  extends Service<SeatType, SeatTypeDAO> implements SeatTypeDAO {
    public SeatTypeService() {
        super(SeatTypeDAO.class);
    }

    @Override
    public int count() {
        return 0;
    }
}
