package booking.Service;

import booking.beans.TransportTripsReview;
import booking.dao.TransportTripsReviewDAO;

import java.util.List;

public class TransportTripsReviewService extends Service<TransportTripsReview, TransportTripsReviewDAO> implements TransportTripsReviewDAO{
    public TransportTripsReviewService() {
        super(TransportTripsReviewDAO.class);
    }

    @Override
    public List<TransportTripsReview> getOrderedPartByProductId(int limit, int offset, String orderBy, String orderDir, long productId) {
        return jdbi.withExtension(TransportTripsReviewDAO.class, dao -> dao.getOrderedPartByProductId(limit, offset, orderBy, orderDir, productId));
    }

    @Override
    public int countByProductId(long productId) {
        return jdbi.withExtension(TransportTripsReviewDAO.class, dao -> dao.countByProductId(productId));
    }

    @Override
    public int sumRatingScoresByProductId(long productId) {
        return jdbi.withExtension(TransportTripsReviewDAO.class, dao -> dao.sumRatingScoresByProductId(productId));
    }

    @Override
    public int count() {
        return jdbi.withExtension(TransportTripsReviewDAO.class, TransportTripsReviewDAO::count);
    }

    @Override
    public void hide(long id) {
        jdbi.useExtension(TransportTripsReviewDAO.class, dao -> dao.hide(id));
    }

    @Override
    public void show(long id) {
        jdbi.useExtension(TransportTripsReviewDAO.class, dao -> dao.show(id));
    }
}
