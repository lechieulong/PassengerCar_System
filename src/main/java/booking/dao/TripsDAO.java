package booking.dao;


import booking.beans.Trips;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;
@RegisterBeanMapper(Trips.class)
public interface TripsDAO extends DAO<Trips>{

    @Override
    @SqlUpdate("INSERT INTO trips (id,routesId) " +
            "VALUES (default, :routesId)")
    @GetGeneratedKeys("id")
    long insert(@BindBean Trips trips);


    @Override
    @SqlUpdate("UPDATE SeatTransport SET name = :name, " +
            "pickUpPoint = :pickUpPoint, " +
            "dropOffPoint = :dropOffPoint, " +
            "WHERE (id = :id) ")
    void update(@BindBean Trips trips);
    @Override
    @SqlUpdate("DELETE FROM trips WHERE id = :id")
    void delete(@Bind("id") long id);


    @Override
    @SqlQuery("SELECT * FROM trips WHERE id = :id")
    Optional<Trips> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM trips")
    List<Trips> getAll();

    @Override
    @SqlQuery("SELECT * FROM trips LIMIT :limit OFFSET :offset")
    List<Trips> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT * FROM trips ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<Trips> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                       @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);



    @SqlQuery("")
    Optional<Trips> getRouteName();
    @SqlQuery("SELECT COUNT(id) FROM trips")
    int count();
}
