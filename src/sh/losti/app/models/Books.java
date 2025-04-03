package sh.losti.app.models;

import java.util.Date;

public class Books {
    private final String id;
    private final String name;
    private final String nameId;
    private final String description;
    private final String biography;
    private final boolean published;
    private final String editorials;
    private final int views;
    private final int saves;
    private final int downloads;
    private final Date createdAt;
    private final Date updatedAt;

    public Books(String id,
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
