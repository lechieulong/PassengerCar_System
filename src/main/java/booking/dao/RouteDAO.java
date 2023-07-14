package booking.dao;

import booking.beans.Route;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(Route.class)
public interface RouteDAO extends DAO<Route>{

    @Override
    @SqlUpdate("INSERT INTO routes (id, name, pickUpPoint, dropOffPoint) " +
            "VALUES (default, :name, :pickUpPoint, :dropOffPoint)")
    @GetGeneratedKeys("id")
    long insert(@BindBean Route route);


    @Override
    @SqlUpdate("UPDATE routes SET name = :name, " +
            "pickUpPoint = :pickUpPoint, " +
            "dropOffPoint = :dropOffPoint, " +
            "WHERE (id = :id) ")
    void update(@BindBean Route route);


    @Override
    @SqlUpdate("DELETE FROM routes WHERE id = :id")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM routes WHERE id = :id")
    Optional<Route> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM routes")
    List<Route> getAll();

    @SqlQuery(" SELECT r.id, r.name, c1.name AS pickUpPointName, c2.name AS dropOffPointName, r.distance FROM routes r JOIN cities c1 ON r.pickUpPoint = c1.id JOIN cities c2 ON r.dropOffPoint = c2.id")
    List<Route> getPickUpPointAndDropPointName();
    @Override
    @SqlQuery("SELECT * FROM Routes LIMIT :limit OFFSET :offset")
    List<Route> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT * FROM Routes ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<Route> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                               @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);
    @SqlQuery("SELECT * FROM routes WHERE name =:name")
    Optional<Route> getByName(@Bind("name") String name);

    @SqlQuery("SELECT COUNT(id) FROM routes")
    int count();
}
