package booking.dao;

import booking.beans.Comment;
import booking.dto.CommentTrip;
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

@RegisterBeanMapper(CommentTrip.class)
public interface CommentDAO extends DAO<CommentTrip> {
    @SqlUpdate("INSERT INTO comment (id, userId, tripstransportId, ratingScore, content, createAt, updateAt) " +
            "VALUES (default, :userID, :tripstransportId, :ratingScore,:content, :createAt,:updateAt )")
    @GetGeneratedKeys("id")
    long insert(@BindBean CommentTrip comment);

    @Override
    @SqlUpdate("")
    void update(@BindBean CommentTrip comment);

    @Override
    @SqlUpdate("DELETE FROM comment WHERE id = :id")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM comment WHERE id = :id")
    Optional<CommentTrip> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM comment;")
    List<CommentTrip> getAll();

    @Override
    @SqlQuery("SELECT * FROM comment LIMIT :limit OFFSET :offset")
    List<CommentTrip> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT * FROM comment ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<CommentTrip> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                   @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);

    @SqlQuery("SELECT COUNT(id) FROM comment")
    int count();

    @SqlQuery("SELECT c.id,u.fullName, c.content, u.id as userId, trip.id as tripstransportId\n" +
            "FROM bookingdb.comment c\n" +
            "JOIN bookingdb.ticket tic ON c.ticketId = tic.id\n" +
            "JOIN bookingdb.user u ON tic.userId = u.id\n" +
            "JOIN bookingdb.tripstransport trip ON tic.tripsTransportId = trip.id\n" +
            "WHERE trip.id = :tripstransportId;\n")
    List<CommentTrip> getCommentByTrip(@Bind("tripstransportId") long tripsTransportId);

}
