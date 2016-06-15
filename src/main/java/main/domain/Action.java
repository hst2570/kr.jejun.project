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
    private Long commentId;
    private String userId;

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

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
