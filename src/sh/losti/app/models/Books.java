package sh.losti.app.models;

import java.util.Date;

public class Books {
    private int id;
    private String name;
    private String nameId;
    private String description;
    private String biography;
    private boolean published;
    private String editorials;
    private int views;
    private int saves;
    private int downloads;
    private Date createdAt;
    private Date updatedAt;

    public Books(
            int id,
            String name,
            String nameId,
            String description,
            String biography,
            boolean published,
            String editorials,
            int views,
            int saves,
            int downloads,
            Date createdAt,
            Date updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.nameId = nameId;
        this.description = description;
        this.biography = biography;
        this.published = published;
        this.editorials = editorials;
        this.views = views;
        this.saves = saves;
        this.downloads = downloads;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
