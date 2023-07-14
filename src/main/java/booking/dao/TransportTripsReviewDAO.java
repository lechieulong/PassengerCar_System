package booking.dao;

import booking.beans.TransportTripsReview;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(TransportTripsReview.class)
public interface TransportTripsReviewDAO extends DAO<TransportTripsReview>{
    @Override
    @SqlUpdate("INSERT INTO TransportTripsReview VALUES (default, :userId, :tripsTransportId, :ratingScore, :content, :isShow, " +
            ":createdAt, :updatedAt)")
    @GetGeneratedKeys("id")
    long insert(@BindBean TransportTripsReview transportTripsReview);

    @Override
    @SqlUpdate("UPDATE TransportTripsReview SET ratingScore = :ratingScore, content = :content, updatedAt = NOW() WHERE id = :id")
    void update(@BindBean TransportTripsReview transportTripsReview);

    @Override
    @SqlUpdate("DELETE FROM TransportTripsReview WHERE id = :id")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM TransportTripsReview WHERE id = :id")
    Optional<TransportTripsReview> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM TransportTripsReview")
    List<TransportTripsReview> getAll();

    @Override
    @SqlQuery("SELECT * FROM TransportTripsReview LIMIT :limit OFFSET :offset")
    List<TransportTripsReview> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT * FROM TransportTripsReview ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<TransportTripsReview> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                       @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);

    @SqlQuery("SELECT pr.*, u.fullname user_fullname " +
            "FROM TransportTripsReview pr " +
            "JOIN user u ON pr.userId = u.id " +
            "WHERE productId = :productId " +
            "ORDER BY <orderBy> <orderDir> " +
            "LIMIT :limit OFFSET :offset")
    List<TransportTripsReview> getOrderedPartByProductId(@Bind("limit") int limit, @Bind("offset") int offset,
                                                  @Define("orderBy") String orderBy, @Define("orderDir") String orderDir,
                                                  @Bind("productId") long productId);

    @SqlQuery("SELECT COUNT(id) FROM TransportTripsReview WHERE productId = :productId")
    int countByProductId(@Bind("productId") long productId);

    @SqlQuery("SELECT SUM(ratingScore) FROM TransportTripsReview WHERE productId = :productId")
    int sumRatingScoresByProductId(@Bind("productId") long productId);

    @SqlQuery("SELECT COUNT(id) FROM TransportTripsReview")
    int count();

    @SqlUpdate("UPDATE TransportTripsReview SET isShow = 0, updatedAt = NOW() WHERE id = :id")
    void hide(@Bind("id") long id);

    @SqlUpdate("UPDATE TransportTripsReview SET isShow = 1, updatedAt = NOW() WHERE id = :id")
    void show(@Bind("id") long id);
}
