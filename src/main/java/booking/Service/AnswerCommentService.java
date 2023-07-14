package booking.Service;

import booking.beans.AnswerComment;
import booking.beans.Comment;
import booking.dao.AnswerCommentDAO;
import booking.dao.CommentDAO;

public class AnswerCommentService extends Service<AnswerComment, AnswerCommentDAO> implements AnswerCommentDAO  {
    public AnswerCommentService() {
        super(AnswerCommentDAO.class);
    }


    @Override
    public int count() {
        return jdbi.withExtension(AnswerCommentDAO.class,AnswerCommentDAO::count);
    }
}

