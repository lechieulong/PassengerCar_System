package booking.beans;

import java.time.LocalDateTime;

public class AnswerComment {
     private long id;
    private long commentID;
    private String content;

    private LocalDateTime createAt;

    public AnswerComment() {
    }

    public AnswerComment(long id, long commentID, String content, LocalDateTime createAt) {
        this.id = id;
        this.commentID = commentID;
        this.content = content;
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCommentID() {
        return commentID;
    }

    public void setCommentID(long commentID) {
        this.commentID = commentID;
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

    @Override
    public String toString() {
        return "AnswerComment{" +
                "id=" + id +
                ", commentID=" + commentID +
                ", content='" + content + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
