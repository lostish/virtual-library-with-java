package sh.losti.app.models;

import java.util.Date;

public class Comment {
    private int userId;
    private int postId;
    private int commentId;
    private String body;
    private String resources;
    private Date createdAt;

    public Comment(
            int userId,
            int postId,
            int commentId,
            String body,
            String resources,
            Date createdAt) {
        this.userId = userId;
        this.postId = postId;
        this.commentId = commentId;
        this.body = body;
        this.resources = resources;
        this.createdAt = createdAt;
    }
}
