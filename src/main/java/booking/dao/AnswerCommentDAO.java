package booking.dao;

import booking.beans.AnswerComment;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(AnswerComment.class)
public interface AnswerCommentDAO extends DAO<AnswerComment> {
    @SqlUpdate("INSERT INTO AnswerComment (id, commentID, content, createAt) " +
            "VALUES (default,  :commentID, :content, :createAt )")
    @GetGeneratedKeys("id")
    long insert(@BindBean AnswerComment answercomment);

    @Override
    @SqlUpdate("")
    void update(@BindBean AnswerComment answercomment);

    @Override
    @SqlUpdate("DELETE FROM answercomment WHERE id = :id")
    void delete(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM answercomment WHERE id = :id")
    Optional<AnswerComment> getById(@Bind("id") long id);

    @Override
    @SqlQuery("SELECT * FROM answercomment;")
    List<AnswerComment> getAll();

    @Override
    @SqlQuery("SELECT * FROM answercomment LIMIT :limit OFFSET :offset")
    List<AnswerComment> getPart(@Bind("limit") int limit, @Bind("offset") int offset);

    @Override
    @SqlQuery("SELECT * FROM answercomment ORDER BY <orderBy> <orderDir> LIMIT :limit OFFSET :offset")
    List<AnswerComment> getOrderedPart(@Bind("limit") int limit, @Bind("offset") int offset,
                                   @Define("orderBy") String orderBy, @Define("orderDir") String orderDir);

    @SqlQuery("SELECT COUNT(id) FROM answercomment")
    int count();

}
