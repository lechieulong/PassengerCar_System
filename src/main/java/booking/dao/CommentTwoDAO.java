package booking.dao;

import booking.beans.Comment;
import booking.dto.CommentTrip;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(Comment.class)
public interface CommentTwoDAO extends DAO<Comment> {
    @SqlUpdate("INSERT INTO comment (id, userId, ticketId, ratingScore, content, createAt, updateAt) " +
            "VALUES (default, :userID, :ticketId, :ratingScore,:content, :createAt,:updateAt )")
    @GetGeneratedKeys("id")
    long insert(@BindBean Comment comment);

    @Override
    @SqlUpdate("")
    void update(@BindBean Comment comment);

    @Override
    @SqlUpdate("DELETE FROM comment WHERE id = :id")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM comment WHERE id = :id")
    Optional<Comment> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM comment;")
    List<Comment> getAll();

    @Override
    @SqlQuery("SELECT * FROM comment LIMIT :limit OFFSET :offset")
    List<Comment> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT * FROM comment ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<Comment> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                   @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);

    @SqlQuery("SELECT COUNT(id) FROM comment")
    int count();

//    @SqlQuery("SELECT c.id,u.fullName, c.content, c.userId, c.tripstransportId\n" +
//            "FROM bookingdb.comment c\n" +
//            "JOIN bookingdb.user u ON c.userId = u.id\n" +
//            "JOIN bookingdb.tripstransport t ON c.tripstransportId = t.id\n" +
//            "WHERE c.tripstransportId = :tripstransportId;\n")
//    List<CommentTrip> getCommentByTrip(@Bind("tripstransportId") long tripsTransportId);

}
