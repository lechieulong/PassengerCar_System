package booking.dao;

import booking.beans.Ticket;
import booking.beans.TicketModifie;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(TicketModifie.class)
public interface TicketModifieDAO extends DAO<TicketModifie> {
    @SqlUpdate("INSERT INTO ticket (userId, tripsTransportId, quantity, totalPrice, status) " +
            "VALUES (:userId, :tripsTransportId, :quantity, :totalPrice, :status)")
    @GetGeneratedKeys("id")
    long insert(@BindBean TicketModifie ticket);


    @Override
    @SqlUpdate("")
    void update(@BindBean TicketModifie ticket);

    @Override
    @SqlUpdate("DELETE FROM Ticket WHERE id = :id")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM Ticket WHERE id = :id")
    Optional<TicketModifie> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM Ticket")
    List<TicketModifie> getAll();

    @Override
    @SqlQuery("SELECT * FROM Ticket LIMIT :limit OFFSET :offset")
    List<TicketModifie> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT * FROM Ticket ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<TicketModifie> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                       @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);


    @SqlQuery("SELECT COUNT(id) FROM Ticket")
    int count();

    @SqlUpdate("UPDATE Ticket SET status = 0 WHERE id = :id")
    void hide(@Bind("id") long id);

    @SqlUpdate("UPDATE Ticket SET status = 1 WHERE id = :id")
    void show(@Bind("id") long id);

    @SqlQuery("SELECT t.*, transport.nameOfTransport, u.fullName as nameOfPassenger, tt.departTime as timeDepart, routes.name as routeName, \n" +
            "       c1.name AS pickUpPoint, c2.name AS dropOffPoint\n" +
            "FROM bookingdb.ticket t\n" +
            "JOIN bookingdb.tripstransport tt ON t.tripsTransportId = tt.id\n" +
            "JOIN bookingdb.trips trips ON tt.tripsId = trips.id\n" +
            "JOIN bookingdb.routes routes ON trips.routesId = routes.id\n" +
            "JOIN bookingdb.transport transport ON tt.transportId = transport.id\n" +
            "JOIN bookingdb.user u ON t.userId = u.id\n" +
            "JOIN bookingdb.cities c1 ON routes.pickUpPoint = c1.id\n" +
            "JOIN bookingdb.cities c2 ON routes.dropOffPoint = c2.id\n" +
            "WHERE u.id = :userId AND tt.departTime >= CURDATE() \n")
    List<TicketModifie> getAllTicket(@Bind("userId") long userId);

    @SqlQuery("SELECT t.*, transport.nameOfTransport, u.fullName as nameOfPassenger, tt.departTime as timeDepart, routes.name as routeName, \n" +
            "       c1.name AS pickUpPoint, c2.name AS dropOffPoint\n" +
            "FROM bookingdb.ticket t\n" +
            "JOIN bookingdb.tripstransport tt ON t.tripsTransportId = tt.id\n" +
            "JOIN bookingdb.trips trips ON tt.tripsId = trips.id\n" +
            "JOIN bookingdb.routes routes ON trips.routesId = routes.id\n" +
            "JOIN bookingdb.transport transport ON tt.transportId = transport.id\n" +
            "JOIN bookingdb.user u ON t.userId = u.id\n" +
            "JOIN bookingdb.cities c1 ON routes.pickUpPoint = c1.id\n" +
            "JOIN bookingdb.cities c2 ON routes.dropOffPoint = c2.id\n" +
            "WHERE t.id = :ticketID \n")
    Optional<TicketModifie> getTicketByID(@Bind("ticketID") long ticketID);
}
