package booking.dao;

import booking.beans.Cities;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(Cities.class)
public interface CitiesDAO extends DAO<Cities> {
    @SqlUpdate("")
    @GetGeneratedKeys("id")
    long insert(@BindBean Cities cities);

    @Override
    @SqlUpdate("")
    void update(@BindBean Cities cities);

    @Override
    @SqlUpdate("DELETE FROM cities WHERE id = :id")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM cities WHERE id = :id")
    Optional<Cities> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM cities;")
    List<Cities> getAll();

    @Override
    @SqlQuery("SELECT * FROM cities LIMIT :limit OFFSET :offset")
    List<Cities> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT * FROM Cities ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<Cities> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                   @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);

//    SqlQuery("SELECT c.* FROM product_category pc JOIN category c ON pc.categoryId = c.id WHERE productId = :productId")
//    Optional<Transport> getByTripsId(@Bind("productId") long productId);

    @SqlQuery("SELECT COUNT(id) FROM cities")
    int count();
}
