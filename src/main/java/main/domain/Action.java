package main.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2016-06-10.
 */
@Entity
public class Action {
    /*
    3. action
     - id, comment, type, user
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long actionId;
    private Long type;
    @JoinColumn(name = "commentId", referencedColumnName="commentId", insertable=false, updatable=false)
    @ManyToOne(optional=false)
    private Comment comment;
    @JoinColumn(name = "userId", referencedColumnName="userId", insertable=false, updatable=false)
    @ManyToOne(optional=false)
    private User user;

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
