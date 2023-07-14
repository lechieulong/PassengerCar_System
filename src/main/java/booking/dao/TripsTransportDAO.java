package booking.dao;

import booking.beans.SeatTransport;
import booking.beans.TripsTransport;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(TripsTransport.class)
public interface TripsTransportDAO extends DAO<TripsTransport>{
    @Override
    @SqlUpdate("INSERT INTO tripsTransport (id,tripsId,transportId,departTime, emptySeat) " +
            "VALUES (default, :tripsId,:transportId,:departTime, :emptySeat)")
    @GetGeneratedKeys("id")
    long insert(@BindBean TripsTransport TripsTransport);


    @Override
    @SqlUpdate("UPDATE tripsTransport SET name = :name, " +
            "pickUpPoint = :pickUpPoint, " +
            "dropOffPoint = :dropOffPoint, " +
            "WHERE (id = :id) ")
    void update(@BindBean TripsTransport TripsTransport);
    @Override
    @SqlUpdate("DELETE FROM tripsTransport WHERE id = :id")
    void delete(@Bind("id") long id);


    @Override
    @SqlQuery("SELECT * FROM tripsTransport WHERE id = :id")
    Optional<TripsTransport> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM tripsTransport")
    List<TripsTransport> getAll();

    @Override
    @SqlQuery("SELECT * FROM tripsTransport LIMIT :limit OFFSET :offset")
    List<TripsTransport> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT t.id, t.routesId, t.timeOfTrips, tt.id AS tripsTransportId, tt.transportId, tt.departTime " +
            "FROM trips t " +
            "INNER JOIN tripsTransport tt ON t.id = tt.tripsId " +
            "ORDER BY :orderBy :orderDir " +
            "LIMIT :limit OFFSET :offset")
    List<TripsTransport> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                        @Bind("orderBy") String orderBy, @Bind("orderDir") String orderDir);

    @SqlQuery("SELECT transportId FROM tripsTransport WHERE id =:id")
    long getTransportIdByTripsTransportId(@Bind("id") long id);

    @SqlQuery("SELECT COUNT(t.id)\n" +
            "FROM trips t\n" +
            "INNER JOIN tripsTransport tt ON t.id = tt.tripsId")
    int count();
    @SqlUpdate("UPDATE tripstransport SET emptySeat = :emptySeat WHERE id = :id ")
    void updateEmptySeat(@Bind("emptySeat")int emptySeat,@Bind("id") long id);


}
