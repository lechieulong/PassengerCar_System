package booking.dto;

public class CommentTrip {

    private long id;
    private long tripstransportId;
    private long userId;

    private String fullName;

    private String content;


    public CommentTrip() {
    }

    public CommentTrip(long id,long tripstransportId, long userId, String fullName, String content) {
        this.id = id;
        this.tripstransportId = tripstransportId;
        this.userId = userId;
        this.fullName = fullName;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTripstransportId() {
        return tripstransportId;
    }

    public void setTripstransportId(long tripstransportId) {
        this.tripstransportId = tripstransportId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentTrip{" +
                "id=" + id +
                "tripstransportId=" + tripstransportId +
                ", userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
