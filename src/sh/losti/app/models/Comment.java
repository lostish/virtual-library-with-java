package sh.losti.app.models;

import java.util.Date;

public class Comment {
    private int userId;
    private int postId;
    private int commentId;
    private String comment;
    private String resources;
    private Date createdAt;

    public Comment(
            int userId,
            int postId,
            int commentId,
            String comment,
            String resources,
            Date createdAt
    ) {
       this.userId = userId;
       this.postId = postId;
       this.commentId = commentId;
       this.comment = comment;
       this.resources = resources;
       this.createdAt = createdAt;
    }
}
