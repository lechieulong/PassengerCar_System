    package booking.beans;

    import org.jetbrains.annotations.Nullable;

    import java.time.LocalDateTime;

    public class TransportTripsReview {
        private long id;
        private long userId;
        private long tripTransportId;
        private int ratingScore;
        private String content;
        private int isShow;
        private LocalDateTime createdAt;
        @Nullable
        private LocalDateTime updatedAt;
        @Nullable
        private User user;
        @Nullable
        private TripsTransport tripsTransport;

        public TransportTripsReview() {
        }

        public TransportTripsReview(long id,
                                    long userId,
                                    long tripTransportId,
                                    int ratingScore,
                                    String content,
                                    int isShow,
                                    LocalDateTime createdAt,
                                    @Nullable LocalDateTime updatedAt) {
            this.id = id;
            this.userId = userId;
            this.tripTransportId = tripTransportId;
            this.ratingScore = ratingScore;
            this.content = content;
            this.isShow = isShow;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getTripsTransportId() {
            return tripTransportId;
        }

        public void setTripTransportId(long tripTransportId) {
            this.tripTransportId = tripTransportId;
        }

        public int getRatingScore() {
            return ratingScore;
        }

        public void setRatingScore(int ratingScore) {
            this.ratingScore = ratingScore;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getIsShow() {
            return isShow;
        }

        public void setIsShow(int isShow) {
            this.isShow = isShow;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }
        @Nullable
        public User getUser() {
            return user;
        }

        public void setUser(@Nullable User user) {
            this.user = user;
        }
        @Nullable
        public TripsTransport getTripsTransport() {
            return tripsTransport;
        }

        public void setTripsTransport(@Nullable TripsTransport tripsTransport) {
            this.tripsTransport = tripsTransport;
        }

        @Override
        public String toString() {
            return "TransportTripsReview{" +
                    "id=" + id +
                    ", userId=" + userId +
                    ", productId=" + tripTransportId +
                    ", ratingScore=" + ratingScore +
                    ", content='" + content + '\'' +
                    ", isShow=" + isShow +
                    ", createdAt=" + createdAt +
                    ", updatedAt=" + updatedAt +
                    ", user=" + user +
                    ", tripsTransport=" + tripsTransport +
                    '}';
        }
    }
