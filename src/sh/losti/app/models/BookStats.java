package sh.losti.app.models;

import java.util.Date;

public class BookStats {
    private int id;
    private int bookId;
    private int bookPostId;
    private int views; // open page
    private int saves; // user bookmark/saves
    private int downloads; // downloads mount
    private int completed; // user completed the book/...
    private int comments; // user comments
    private double averageRating; // result of rating
    private Date createdAt;
    private Date updatedAt;

    public BookStats(
            int id,
            int bookId,
            int bookPostId,
            int views,
            int saves,
            int downloads,
            int completed,
            int comments,
            double averageRating,
            Date createdAt,
            Date updatedAt) {
        this.id = id;
        this.bookId = bookId;
        this.bookPostId = bookPostId;
        this.views = views;
        this.saves = saves;
        this.downloads = downloads;
        this.completed = completed;
        this.comments = comments;
        this.averageRating = averageRating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
