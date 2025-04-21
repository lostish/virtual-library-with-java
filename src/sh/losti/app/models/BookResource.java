package sh.losti.app.models;

public class BookResource {
    private int bookResourceId;
    private int bookPostId;
    private String bookResourceUrl;

    public BookResource(
            int bookResourceId,
            int bookPostId,
            String bookResourceUrl
    ) {
        this.bookResourceId = bookResourceId;
        this.bookPostId = bookPostId;
        this.bookResourceUrl = bookResourceUrl;
    }
}
