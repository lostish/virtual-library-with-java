package sh.losti.app.models;

import java.util.Date;

public class Profile {
    private int id;
    private int userId;
    private String biography;
    private String networks;
    private String books;
    private Date createdAt;
    private Date updatedAt;

    public Profile(
            int id,
            int userId,
            String biography,
            String networks,
            String books,
            Date createdAt,
            Date updatedAt) {
        this.id = id;
        this.userId = userId;
        this.biography = biography;
        this.networks = networks;
        this.books = books;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
