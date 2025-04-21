package sh.losti.app.models;

public class BookStats {
    private int views; // open page
    private int saves; // user bookmark/saves
    private int downloads; // downloads mount
    private int completed; // user completed the book/...
    private int comments; // user comments
    private double averageRating; // result of rating

    public BookStats(
            int views,
            int saves,
            int downloads,
            int completed,
            int comments,
            double averageRating
    ) {
        this.views = views;
        this.saves = saves;
        this.downloads = downloads;
        this.completed = completed;
        this.comments = comments;
    }
}
