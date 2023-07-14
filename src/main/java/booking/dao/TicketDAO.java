package booking.dao;

import booking.beans.Ticket;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;
@RegisterBeanMapper(Ticket.class)
public interface TicketDAO extends DAO<Ticket> {
    @SqlUpdate("INSERT INTO ticket (userId, tripsTransportId, seatTransportId, quantity, totalPrice, status) " +
            "VALUES (:userId, :tripsTransportId, :seatTransportId, :quantity, :totalPrice, :status)")
    @GetGeneratedKeys("id")
    long insert(@BindBean Ticket ticket);


    @Override
    @SqlUpdate("")
    void update(@BindBean Ticket ticket);

    @Override
    @SqlUpdate("DELETE FROM Ticket WHERE id = :id")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM Ticket WHERE id = :id")
    Optional<Ticket> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM Ticket")
    List<Ticket> getAll();

    @Override
    @SqlQuery("SELECT * FROM Ticket LIMIT :limit OFFSET :offset")
    List<Ticket> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT * FROM Ticket ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<Ticket> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                       @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);

//    SqlQuery("SELECT c.* FROM product_category pc JOIN category c ON pc.categoryId = c.id WHERE productId = :productId")
//    Optional<Transport> getByTripsId(@Bind("productId") long productId);

    @SqlUpdate("UPDATE `bookingdb`.`ticket`\n" +
            "SET `status` = 0 \n" +
            "ORDER BY `id` DESC\n" +
            "LIMIT 1;\n")
    void updateStatus();

    @SqlUpdate("UPDATE Ticket\n" +
            "SET status = 0 WHERE id = :id"
            )
    void updateStatusByID(@Bind("id") long id);


    @SqlQuery("SELECT COUNT(id) FROM Ticket")
    int count();

    @SqlUpdate("UPDATE Ticket SET status = 0 WHERE id = :id")
    void hide(@Bind("id") long id);

    @SqlUpdate("UPDATE Ticket SET status = 1 WHERE id = :id")
    void show(@Bind("id") long id);
}
