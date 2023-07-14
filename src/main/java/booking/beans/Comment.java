package booking.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Comment {
     private long id;
     private long ticketId;

    private int ratingScore;
    private String content;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Comment() {
    }

    public Comment(long id, long ticketId,  int ratingScore, String content, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.ticketId = ticketId;
        this.ratingScore = ratingScore;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
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



    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return new StringJoiner(",",Comment.class.getSimpleName()+"[","]")
                .add("id =" +id)
                .add("ticketId =" +ticketId)
                .add("ratingScore =" +ratingScore)
                .add("content =" +content)
                .add("createAt =" +createAt)
                .add("updateAt =" +updateAt)
                .toString();
    }
}


