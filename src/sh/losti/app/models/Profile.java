package sh.losti.app.models;

import java.util.Date;

public class Profile {
    private int id;
    private int userId;
    private String lastWorkNameId;
    private String editorialNameId;
    private String biography;
    private Date createdAt;
    private Date updatedAt;

    public Profile(
            int id,
            int userId,
            String lastWorkNameId,
            String editorialNameId,
            String biography,
            Date createdAt,
            Date updatedAt) {
        this.id = id;
        this.userId = userId;
        this.lastWorkNameId = lastWorkNameId;
        this.editorialNameId = editorialNameId;
        this.biography = biography;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
