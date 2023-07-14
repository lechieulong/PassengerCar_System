package booking.dao;

import booking.dto.TripPopular;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(TripPopular.class)
public interface TripsPopularDAO extends DAO<TripPopular> {
    @SqlUpdate("")
    @GetGeneratedKeys("id")
    long insert(@BindBean TripPopular cities);

    @Override
    @SqlUpdate("")
    void update(@BindBean TripPopular cities);

    @Override
    @SqlUpdate("")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("")
    Optional<TripPopular> getById(@Bind("id") long id);

    @Override
    @SqlQuery("")
    List<TripPopular> getAll();

    @Override
    @SqlQuery("")
    List<TripPopular> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("")
    List<TripPopular> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                                      @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);
    @SqlQuery("SELECT\n" +
            "  tt.id AS tripsTransportId,\n" +
            "  t.nameOfTransport,\n" +
            "  t.imageName,\n" +
            "  r.name AS tripName,\n" +
            "  t.totalSeat,\n" +
            "  tt.departTime AS timeOfTrips\n" +
            "FROM\n" +
            "  bookingdb.tripstransport tt\n" +
            "  INNER JOIN bookingdb.transport t ON tt.transportId = t.id\n" +
            "  INNER JOIN bookingdb.ticket tic ON tic.tripsTransportId = tt.id\n" +
            "  INNER JOIN bookingdb.trips tr ON tt.tripsId = tr.id\n" +
            "  INNER JOIN bookingdb.routes r ON tr.routesId = r.id\n" +
            "WHERE\n" +
            "  DATE(tt.departTime) >= CURDATE() \n" +
            "GROUP BY\n" +
            "  tt.id, t.nameOfTransport, t.imageName, r.name, t.totalSeat, tt.departTime\n" +
            "ORDER BY\n" +
            "  COUNT(tic.quantity) DESC\n" +
            "LIMIT 7;\n")
    List<TripPopular> getAllTrips();

    @SqlQuery("SELECT\n" +
            "  tt.id AS tripsTransportId,\n" +
            "  t.nameOfTransport,\n" +
            "  t.imageName,\n" +
            "  r.name AS tripName,\n" +
            "  t.totalSeat,\n" +
            "  tt.departTime AS timeOfTrips\n" +
            "FROM\n" +
            "  bookingdb.tripstransport tt\n" +
            "  INNER JOIN bookingdb.transport t ON tt.transportId = t.id\n" +
            "  INNER JOIN bookingdb.ticket tic ON tic.tripsTransportId = tt.id\n" +
            "  INNER JOIN bookingdb.trips tr ON tt.tripsId = tr.id\n" +
            "  INNER JOIN bookingdb.routes r ON tr.routesId = r.id\n" +
            "WHERE\n" +
            "  DATE(tt.departTime) >= CURDATE()\n" +
            "    AND HOUR(tt.departTime) < 12 -- Afternoon trips (12:00 PM to 5:59 PM)\n" +
            "GROUP BY\n" +
            "  tt.id, t.nameOfTransport, t.imageName, r.name, t.totalSeat, tt.departTime\n" +
            "ORDER BY\n" +
            "  COUNT(tic.tripsTransportId) DESC\n" +
            "LIMIT 5;\n"
            )
    List<TripPopular> sortMorning();


    @SqlQuery("SELECT\n" +
            "    tt.id AS tripsTransportId,\n" +
            "    t.nameOfTransport,\n" +
            "    t.imageName,\n" +
            "    r.name AS tripName,\n" +
            "    t.totalSeat,\n" +
            "    tt.departTime AS timeOfTrips\n" +
            "            FROM\n" +
            "    bookingdb.tripstransport tt\n" +
            "    INNER JOIN bookingdb.transport t ON tt.transportId = t.id\n" +
            "    INNER JOIN bookingdb.ticket tic ON tic.tripsTransportId = tt.id\n" +
            "    INNER JOIN bookingdb.trips tr ON tt.tripsId = tr.id\n" +
            "    INNER JOIN bookingdb.routes r ON tr.routesId = r.id\n" +
            "            WHERE\n" +
            "    DATE(tt.departTime) >= CURDATE()\n" +
            "    AND (\n" +
            "    (HOUR(tt.departTime) >= 12 AND HOUR(tt.departTime) < 18) -- Afternoon trips (12:00 PM to 5:59 PM)\n" +
            "  )\n" +
            "    GROUP BY\n" +
            "    tt.id, t.nameOfTransport, t.imageName, r.name, t.totalSeat, tt.departTime\n" +
            "    ORDER BY\n" +
            "    COUNT(tic.tripsTransportId) DESC\n" +
            "    LIMIT 5;"
    )
    List<TripPopular> sortAfternoon();

    @SqlQuery("SELECT\n" +
            "    tt.id AS tripsTransportId,\n" +
            "    t.nameOfTransport,\n" +
            "    t.imageName,\n" +
            "    r.name AS tripName,\n" +
            "    t.totalSeat,\n" +
            "    tt.departTime AS timeOfTrips\n" +
            "            FROM\n" +
            "    bookingdb.tripstransport tt\n" +
            "    INNER JOIN bookingdb.transport t ON tt.transportId = t.id\n" +
            "    INNER JOIN bookingdb.ticket tic ON tic.tripsTransportId = tt.id\n" +
            "    INNER JOIN bookingdb.trips tr ON tt.tripsId = tr.id\n" +
            "    INNER JOIN bookingdb.routes r ON tr.routesId = r.id\n" +
            "            WHERE\n" +
            "    DATE(tt.departTime) >= CURDATE()\n" +
            "    AND (\n" +
            "    (HOUR(tt.departTime) >= 18 AND HOUR(tt.departTime) < 0) -- Morning trips (0:00 AM to 11:59 AM)\n" +
            "  )\n" +
            "    GROUP BY\n" +
            "    tt.id, t.nameOfTransport, t.imageName, r.name, t.totalSeat, tt.departTime\n" +
            "    ORDER BY\n" +
            "    COUNT(tic.tripsTransportId) DESC\n" +
            "    LIMIT 5;"
    )
    List<TripPopular> sortNight();



}
