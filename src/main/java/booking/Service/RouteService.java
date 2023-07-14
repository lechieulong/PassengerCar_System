package booking.Service;

import booking.beans.Route;
import booking.dao.RouteDAO;

import java.util.List;
import java.util.Optional;

public class RouteService extends Service<Route, RouteDAO> implements RouteDAO {
    public RouteService() {
        super(RouteDAO.class);
    }

    @Override
    public List<Route> getPickUpPointAndDropPointName() {
        return jdbi.withExtension(RouteDAO.class, RouteDAO::getPickUpPointAndDropPointName);
    }

    @Override
    public Optional<Route> getByName(String name) {
        return jdbi.withExtension(RouteDAO.class,dao -> dao.getByName(name));
    }

    @Override
    public int count() {
        return jdbi.withExtension(RouteDAO.class,RouteDAO::count);
    }
}
