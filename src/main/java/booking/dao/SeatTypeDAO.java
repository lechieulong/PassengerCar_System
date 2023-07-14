package booking.dao;

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

@RegisterBeanMapper(SeatType.class)
public interface SeatTypeDAO extends DAO<SeatType>{
    @SqlUpdate("")
    @GetGeneratedKeys("id")
    long insert(@BindBean SeatType seatType);

    @Override
    @SqlUpdate("")
    void update(@BindBean SeatType seatType);

    @Override
    @SqlUpdate("DELETE FROM SeatType WHERE id = :id")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM SeatType WHERE id = :id")
    Optional<SeatType> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM SeatType")
    List<SeatType> getAll();

    @Override
    @SqlQuery("SELECT * FROM SeatType LIMIT :limit OFFSET :offset")
    List<SeatType> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT * FROM SeatType ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<SeatType> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);

    @SqlQuery("SELECT COUNT(id) FROM SeatType")
    int count();
}
