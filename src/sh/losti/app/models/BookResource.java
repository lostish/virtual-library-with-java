package sh.losti.app.models;

import java.util.Date;

public class BookResource {
    private int bookResourceId;
    private int bookPostId;
    private String bookResourceUrl;
    private Date createdAt;
    private Date updatedAt;

    public BookResource(
            int bookResourceId,
            int bookPostId,
            String bookResourceUrl,
            Date createdAt,
            Date updatedAt) {
        this.bookResourceId = bookResourceId;
        this.bookPostId = bookPostId;
        this.bookResourceUrl = bookResourceUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
