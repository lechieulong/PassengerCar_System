package booking.dao;

import booking.beans.SeatTransport;
import booking.dto.TripsTransportWithRoutes;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;
@RegisterBeanMapper(TripsTransportWithRoutes.class)
public interface TripsTransportWithRoutesDAO extends DAO<TripsTransportWithRoutes>{
    @SqlUpdate("")
    @GetGeneratedKeys("id")
    long insert(@BindBean TripsTransportWithRoutes tripsTransportWithRoutesDAO);

    @Override
    @SqlUpdate("")
    void update(@BindBean TripsTransportWithRoutes tripsTransportWithRoutesDAO);

    @Override
    @SqlUpdate("DELETE FROM tripsTransportWithRoutes WHERE id = :id")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery(
            " SELECT t.*, tt.id AS tripsTransportId,tt.emptySeat, tt.departTime AS tripsTransportDepartTime, r.name FROM transport t JOIN tripsTransport tt ON t.id = tt.transportId JOIN trips tr ON tt.tripsId = tr.id JOIN routes r ON tr.routesId = r.id   WHERE tt.id = :tripsTransportId "
                )
    Optional<TripsTransportWithRoutes> getById(@Bind("tripsTransportId") long tripsTransportId);

    @Override
    @SqlQuery("SELECT * FROM tripsTransportWithRoutes;")
    List<TripsTransportWithRoutes> getAll();

    @Override
    @SqlQuery("SELECT * FROM cities LIMIT :limit OFFSET :offset")
    List<TripsTransportWithRoutes> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery(" SELECT t.*,tt.id AS tripsTransportId, tt.departTime AS tripsTransportDepartTime, r.name FROM transport t JOIN tripsTransport tt ON t.id = tt.transportId JOIN trips tr ON tt.tripsId = tr.id JOIN routes r ON tr.routesId = r.id ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<TripsTransportWithRoutes> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                                     @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);
    @SqlQuery("SELECT t.*, tt.id AS tripsTransportId, tt.departTime AS tripsTransportDepartTime, r.name" +
            "FROM transport t" +
            "JOIN tripsTransport tt ON t.id = tt.transportId" +
            "JOIN trips tr ON tt.tripsId = tr.id" +
            "JOIN routes r ON tr.routesId = r.id" )
    List<TripsTransportWithRoutes>GetAllTripsTransportWithRoutes();
//    SELECT t.*,tt.id AS tripsTransportId, tt.departTime AS tripsTransportDepartTime, tr.timeOfTrips, r.name FROM transport t
//    JOIN tripsTransport tt ON t.id = tt.transportId JOIN trips tr ON tt.tripsId = tr.id
//    JOIN routes r ON tr.routesId = r.id


    @SqlQuery("SELECT count(*)\n" +
            "FROM transport t\n" +
            "JOIN tripsTransport tt ON t.id = tt.transportId\n" +
            "JOIN trips tr ON tt.tripsId = tr.id\n" +
            "JOIN routes r ON tr.routesId = r.id")
    int count();
}
