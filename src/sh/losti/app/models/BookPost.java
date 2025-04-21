package sh.losti.app.models;

import java.util.Date;

public class BookPost {
    private int bookId;
    private int bookPostId;
    private int bookResourceId;
    private int chapterNumber;
    private String title;
    private Date createdAt;
    private Date updatedAt;

    public BookPost(
            int bookId,
            int bookPostId,
            int bookResourceId,
            int chapterNumber,
            String title,
            Date createdAt,
            Date updatedAt
    ) {
        this.bookId = bookId;
        this.bookPostId = bookPostId;
        this.bookResourceId = bookResourceId;
        this.chapterNumber = chapterNumber;
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
