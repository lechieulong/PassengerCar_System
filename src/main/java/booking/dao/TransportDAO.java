package booking.dao;

import booking.beans.Transport;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;
@RegisterBeanMapper(Transport.class)
public interface TransportDAO extends DAO<Transport> {
    @SqlUpdate("INSERT INTO transport (nameOfTransport, imageName, licensePlate, description, totalSeat) "
            +
            "VALUES (:nameOfTransport, :imageName, :licensePlate ,:description , :totalSeat)")
    @GetGeneratedKeys("id")
    long insert(@BindBean Transport transport);

    @Override
    @SqlUpdate("UPDATE transport SET nameOfTransport = :nameOfTransport, " +
            "licensePlate = :licensePlate, imageName = :imageName, " +
            "description = :description, " +
            "totalSeat = :totalSeat " +
            "WHERE (id = :id) ")
    void update(@BindBean Transport transport);

    @Override
    @SqlUpdate("DELETE FROM transport WHERE id = :id")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM transport WHERE id = :id")
    Optional<Transport> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM transport")
    List<Transport> getAll();

    @Override
    @SqlQuery("SELECT * FROM transport LIMIT :limit OFFSET :offset")
    List<Transport> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT * FROM transport ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<Transport> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                   @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);


    @SqlUpdate("UPDATE transport SET totalSeat = :totalSeat WHERE (id = :id)")
    void updateQuantityById(@Bind("totalSeat")int totalSeat,@Bind("id") long id);

    @SqlQuery("SELECT COUNT(id) FROM Transport")
    int count();

    @SqlQuery("SELECT *\n" +
            "FROM bookingdb.transport t\n" +
            "WHERE t.id IN (\n" +
            "    SELECT st.transportId\n" +
            "    FROM bookingdb.seattransport st\n" +
            "    INNER JOIN bookingdb.seattype stype ON st.typeOfSeatId = stype.id\n" +
            "    WHERE stype.name = 'SIT'\n" +
            ");\n ")
    List<Transport> sortSitCar();

    @SqlQuery("SELECT *\n" +
            "FROM bookingdb.transport t\n" +
            "WHERE t.id IN (\n" +
            "    SELECT st.transportId\n" +
            "    FROM bookingdb.seattransport st\n" +
            "    INNER JOIN bookingdb.seattype stype ON st.typeOfSeatId = stype.id\n" +
            "    WHERE stype.name = 'LIE'\n" +
            ");\n ")
    List<Transport> sortLieCar();
}
