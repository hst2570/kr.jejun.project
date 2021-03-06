package main.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2016-06-10.
 */
@Entity
public class Comment {
    /*
    2. comment
     - id, user, date, content
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long commentId;

    @JoinColumn(name = "user_id")
    @ManyToOne(optional=false)
    private User user;
    private String date;
    private String content;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
