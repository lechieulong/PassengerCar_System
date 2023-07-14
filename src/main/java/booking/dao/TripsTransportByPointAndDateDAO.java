package booking.dao;

import booking.dto.TripsTransportByPointAndDate;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;
@RegisterBeanMapper(TripsTransportByPointAndDate.class)
public interface TripsTransportByPointAndDateDAO extends DAO<TripsTransportByPointAndDate> {
    @SqlUpdate("")
    @GetGeneratedKeys("id")
    long insert(@BindBean TripsTransportByPointAndDate cities);

    @Override
    @SqlUpdate("")
    void update(@BindBean TripsTransportByPointAndDate cities);

    @Override
    @SqlUpdate("")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT transport.*, seatTransport.*, seatType.*, routes.name AS route_name, routes.pickUpPoint, routes.dropOffPoint , tripsTransport.id AS tripsTransport_id, tripsTransport.departTime, tripsTransport.emptySeat  " +
            "FROM tripsTransport " +
            "JOIN transport ON tripsTransport.transportId = transport.id " +
            "JOIN seatTransport ON tripsTransport.transportId = seatTransport.transportId " +
            "JOIN seatType ON seatTransport.typeOfSeatId = seatType.id " +
            "JOIN trips ON tripsTransport.tripsId = trips.id " +
            "JOIN routes ON trips.routesId = routes.id WHERE tripsTransport.id = :id")
    Optional<TripsTransportByPointAndDate> getById(@Bind("id") long id);

    @Override
    @SqlQuery("")
    List<TripsTransportByPointAndDate> getAll();

    @Override
    @SqlQuery("")
    List<TripsTransportByPointAndDate> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("")
    List<TripsTransportByPointAndDate> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);

    @SqlQuery("SELECT transport.*, seatTransport.*, seatType.*, routes.name AS route_name, tripsTransport.id AS tripsTransport_id, tripsTransport.departTime,tripsTransport.emptySeat  " +
            "FROM tripsTransport " +
            "JOIN transport ON tripsTransport.transportId = transport.id " +
            "JOIN seatTransport ON tripsTransport.transportId = seatTransport.transportId " +
            "JOIN seatType ON seatTransport.typeOfSeatId = seatType.id " +
            "JOIN trips ON tripsTransport.tripsId = trips.id " +
            "JOIN routes ON trips.routesId = routes.id " +
            "WHERE routes.pickUpPoint = :pickUpPoint " +
            "  AND routes.dropOffPoint = :dropOffPoint " +
            "  AND tripsTransport.departTime LIKE CONCAT('%', :date, '%')")
    List<TripsTransportByPointAndDate> getAllTripsAndTransportByPointAndDate(@Bind("dropOffPoint") long dropOffPoint, @Bind("pickUpPoint") long pickUpPoint, @Bind("date") String date);

    @SqlQuery("SELECT transport.*, seatTransport.*, seatType.*, routes.name AS route_name, tripsTransport.id AS tripsTransport_id, tripsTransport.departTime, tripsTransport.emptySeat \n" +
            "            FROM tripsTransport \n" +
            "            JOIN transport ON tripsTransport.transportId = transport.id \n" +
            "            JOIN seatTransport ON tripsTransport.transportId = seatTransport.transportId \n" +
            "            JOIN seatType ON seatTransport.typeOfSeatId = seatType.id \n" +
            "            JOIN trips ON tripsTransport.tripsId = trips.id\n" +
            "            JOIN routes ON trips.routesId = routes.id\n" +
            "            WHERE routes.pickUpPoint = :pickUpPoint \n" +
            "              AND routes.dropOffPoint = :dropOffPoint \n" +
            "              AND tripsTransport.departTime LIKE CONCAT('%', :date, '%')\n" +
            "           AND seattype.name = 'LIE'\n" +
            "               ")
    List<TripsTransportByPointAndDate> sortLIECar(@Bind("dropOffPoint") long dropOffPoint, @Bind("pickUpPoint") long pickUpPoint, @Bind("date") String date);

    @SqlQuery("SELECT transport.*, seatTransport.*, seatType.*, routes.name AS route_name, tripsTransport.id AS tripsTransport_id, tripsTransport.departTime, tripsTransport.emptySeat \n" +
            "            FROM tripsTransport \n" +
            "            JOIN transport ON tripsTransport.transportId = transport.id \n" +
            "            JOIN seatTransport ON tripsTransport.transportId = seatTransport.transportId \n" +
            "            JOIN seatType ON seatTransport.typeOfSeatId = seatType.id \n" +
            "            JOIN trips ON tripsTransport.tripsId = trips.id\n" +
            "            JOIN routes ON trips.routesId = routes.id\n" +
            "            WHERE routes.pickUpPoint = :pickUpPoint \n" +
            "              AND routes.dropOffPoint = :dropOffPoint \n" +
            "              AND tripsTransport.departTime LIKE CONCAT('%', :date, '%')\n" +
            "           AND seattype.name = 'SIT'\n" +
            "               ")
    List<TripsTransportByPointAndDate> sortSITCar(@Bind("dropOffPoint") long dropOffPoint, @Bind("pickUpPoint") long pickUpPoint, @Bind("date") String date);


    @SqlQuery("SELECT transport.*, seatTransport.*, seatType.*, routes.name AS route_name, tripsTransport.id AS tripsTransport_id, tripsTransport.departTime, tripsTransport.emptySeat \n" +
            "            FROM tripsTransport \n" +
            "            JOIN transport ON tripsTransport.transportId = transport.id \n" +
            "            JOIN seatTransport ON tripsTransport.transportId = seatTransport.transportId \n" +
            "            JOIN seatType ON seatTransport.typeOfSeatId = seatType.id \n" +
            "            JOIN trips ON tripsTransport.tripsId = trips.id\n" +
            "            JOIN routes ON trips.routesId = routes.id\n" +
            "            WHERE routes.pickUpPoint = :pickUpPoint \n" +
            "              AND routes.dropOffPoint = :dropOffPoint \n" +
            "              AND tripsTransport.departTime LIKE CONCAT('%', :date, '%')\n" +
            "            ORDER BY seattransport.price ASC\n" +
            "               ")
    List<TripsTransportByPointAndDate> sortCheapPrice(@Bind("dropOffPoint") long dropOffPoint, @Bind("pickUpPoint") long pickUpPoint, @Bind("date") String date);


    @SqlQuery("SELECT transport.*, seatTransport.*, seatType.*, routes.name AS route_name, tripsTransport.id AS tripsTransport_id, tripsTransport.departTime,tripsTransport.emptySeat \n" +
            "            FROM tripsTransport \n" +
            "            JOIN transport ON tripsTransport.transportId = transport.id \n" +
            "            JOIN seatTransport ON tripsTransport.transportId = seatTransport.transportId \n" +
            "            JOIN seatType ON seatTransport.typeOfSeatId = seatType.id \n" +
            "            JOIN trips ON tripsTransport.tripsId = trips.id\n" +
            "            JOIN routes ON trips.routesId = routes.id\n" +
            "            WHERE routes.pickUpPoint = :pickUpPoint \n" +
            "              AND routes.dropOffPoint = :dropOffPoint \n" +
            "              AND tripsTransport.departTime LIKE CONCAT('%', :date, '%')\n" +
            "            ORDER BY seattransport.price DESC\n" +
            "               ")
    List<TripsTransportByPointAndDate> sortExpensivePrice(@Bind("dropOffPoint") long dropOffPoint, @Bind("pickUpPoint") long pickUpPoint, @Bind("date") String date);

    @SqlQuery("SELECT transport.*, seatTransport.*, seatType.*, routes.name AS route_name, tripsTransport.id AS tripsTransport_id, tripsTransport.departTime,tripsTransport.emptySeat\n" +
            "            FROM tripsTransport \n" +
            "            JOIN transport ON tripsTransport.transportId = transport.id \n" +
            "            JOIN seatTransport ON tripsTransport.transportId = seatTransport.transportId \n" +
            "            JOIN seatType ON seatTransport.typeOfSeatId = seatType.id \n" +
            "            JOIN trips ON tripsTransport.tripsId = trips.id\n" +
            "            JOIN routes ON trips.routesId = routes.id\n" +
            "            WHERE routes.pickUpPoint = :pickUpPoint \n" +
            "              AND routes.dropOffPoint = :dropOffPoint \n" +
            "              AND tripsTransport.departTime LIKE CONCAT('%', :date, '%')\n" +
            "            ORDER BY tripsTransport.departTime DESC \n" +
            "               ")
    List<TripsTransportByPointAndDate> sortEarlyTime(@Bind("dropOffPoint") long dropOffPoint, @Bind("pickUpPoint") long pickUpPoint, @Bind("date") String date);

    @SqlQuery("SELECT transport.*, seatTransport.*, seatType.*, routes.name AS route_name, tripsTransport.id AS tripsTransport_id, tripsTransport.departTime,tripsTransport.emptySeat \n" +
            "            FROM tripsTransport \n" +
            "            JOIN transport ON tripsTransport.transportId = transport.id \n" +
            "            JOIN seatTransport ON tripsTransport.transportId = seatTransport.transportId \n" +
            "            JOIN seatType ON seatTransport.typeOfSeatId = seatType.id \n" +
            "            JOIN trips ON tripsTransport.tripsId = trips.id\n" +
            "            JOIN routes ON trips.routesId = routes.id\n" +
            "            WHERE routes.pickUpPoint = :pickUpPoint \n" +
            "              AND routes.dropOffPoint = :dropOffPoint \n" +
            "              AND tripsTransport.departTime LIKE CONCAT('%', :date, '%')\n" +
            "            ORDER BY tripsTransport.departTime ASC \n" +
            "               ")
    List<TripsTransportByPointAndDate> sortLateTime(@Bind("dropOffPoint") long dropOffPoint, @Bind("pickUpPoint") long pickUpPoint, @Bind("date") String date);

    @SqlQuery("SELECT avg_ratingScore, transport.*, seatTransport.*, seatType.*, routes.name AS route_name, tripsTransport.id AS tripsTransport_id, tripsTransport.departTime, tripsTransport.emptySeat\n" +
            "FROM (\n" +
            "  SELECT AVG(comment.ratingScore) AS avg_ratingScore, tripsTransport.id\n" +
            "  FROM tripsTransport\n" +
            "  JOIN comment ON tripsTransport.id = comment.tripstransportId\n" +
            "  JOIN trips ON tripsTransport.tripsId = trips.id\n" +
            "  JOIN routes ON trips.routesId = routes.id\n" +
            "  WHERE routes.pickUpPoint = :pickUpPoint\n" +
            "    AND routes.dropOffPoint = :dropOffPoint\n" +
            "    AND tripsTransport.departTime LIKE CONCAT('%', :date, '%')\n" +
            "  GROUP BY tripsTransport.id\n" +
            ") AS avg_scores\n" +
            "JOIN tripsTransport ON avg_scores.id = tripsTransport.id\n" +
            "JOIN transport ON tripsTransport.transportId = transport.id\n" +
            "JOIN seatTransport ON tripsTransport.transportId = seatTransport.transportId\n" +
            "JOIN seatType ON seatTransport.typeOfSeatId = seatType.id\n" +
            "JOIN trips ON tripsTransport.tripsId = trips.id\n" +
            "JOIN routes ON trips.routesId = routes.id\n" +
            "ORDER BY avg_scores.avg_ratingScore DESC;\n ")
    List<TripsTransportByPointAndDate> sortTripByCar(@Bind("dropOffPoint") long dropOffPoint, @Bind("pickUpPoint") long pickUpPoint, @Bind("date") String date);

}
