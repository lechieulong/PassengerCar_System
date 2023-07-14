package booking.Service;

import booking.beans.Comment;
import booking.dao.CommentDAO;
import booking.dao.CommentTwoDAO;
import booking.dto.CommentTrip;

import java.util.List;

public class CommentTwoService extends Service<Comment, CommentTwoDAO> implements CommentTwoDAO  {
    public CommentTwoService() {
        super(CommentTwoDAO.class);
    }

    @Override
    public int count() {
        return 0;
    }


}

