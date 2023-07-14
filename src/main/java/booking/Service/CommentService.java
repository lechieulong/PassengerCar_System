package booking.Service;

import booking.beans.Comment;
import booking.dao.CommentDAO;
import booking.dto.CommentTrip;

import java.util.List;

public class CommentService extends Service<CommentTrip, CommentDAO> implements CommentDAO  {
    public CommentService() {
        super(CommentDAO.class);
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<CommentTrip> getCommentByTrip(long tripstransportId) {
        return jdbi.withExtension(CommentDAO.class, dao -> dao.getCommentByTrip(tripstransportId));
    }
}

