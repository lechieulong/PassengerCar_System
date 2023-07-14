package booking.dao;

import booking.beans.SeatTransport;
import booking.beans.SeatType;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(SeatTransport.class)
public interface SeatTransportDAO extends DAO<SeatTransport>{
    @Override
    @SqlUpdate("INSERT INTO SeatTransport (id,transportId,typeOfSeatId,quantity,price) " +
            "VALUES (default, :transportId,:typeOfSeatId,:quantity,:price)")
    @GetGeneratedKeys("id")
    long insert(@BindBean SeatTransport seatTransport);


    @Override
    @SqlUpdate("UPDATE SeatTransport SET name = :name, " +
            "pickUpPoint = :pickUpPoint, " +
            "dropOffPoint = :dropOffPoint, " +
            "WHERE (id = :id) ")
    void update(@BindBean SeatTransport seatTransport);
    @Override
    @SqlUpdate("DELETE FROM SeatType WHERE id = :id")
    void delete(@Bind("id") long id);
    @Override
    @SqlQuery("SELECT * FROM SeatType WHERE id = :id")
    Optional<SeatTransport> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM SeatType")
    List<SeatTransport> getAll();

    @Override
    @SqlQuery("SELECT * FROM SeatType LIMIT :limit OFFSET :offset")
    List<SeatTransport> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @SqlQuery("SELECT st.* FROM tripsTransport tt JOIN seatTransport st ON tt.transportId = st.transportId WHERE tt.id = :id")
    Optional<SeatTransport> getQuantityAndPriceByTrips(@Bind("id") long id);


    @SqlUpdate("UPDATE SeatTransport SET quantity = :quantity WHERE (id = :id) ")
    void updateQuantity(@Bind("quantity")int quantity,@Bind("id") long id);

    @SqlQuery("SELECT quantity FROM SeatTransport  WHERE (transportId = :transportId)")
    Integer  getQuantity(@Bind("transportId") long id);

    @Override
    @SqlQuery("SELECT * FROM SeatType ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<SeatTransport> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                  @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);
}


