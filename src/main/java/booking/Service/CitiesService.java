package booking.Service;

import booking.beans.Cities;
import booking.dao.CitiesDAO;
import booking.dao.DAO;

import java.util.List;

public class CitiesService extends Service<Cities, CitiesDAO> implements CitiesDAO  {
    public CitiesService() {
        super(CitiesDAO.class);
    }


    @Override
    public int count() {
        return jdbi.withExtension(CitiesDAO.class,CitiesDAO::count);
    }
}
