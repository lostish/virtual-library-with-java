package sh.losti.app.builders;

import sh.losti.app.interfaces.builders.IBooksBuilder;
import sh.losti.app.models.Books;

import java.util.Date;

public class BookBuilder implements IBooksBuilder {
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

    @Override
    public IBooksBuilder setId(int id) {
        this.id = id;
        return this;
    }
    @Override
    public IBooksBuilder setName(String name) {
        this.name = name;
        return this;
    }
    @Override
    public IBooksBuilder setNameId(String nameId) {
        this.nameId = nameId;
        return this;
    }
    @Override
    public IBooksBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
    @Override
    public IBooksBuilder setBiography(String biography) {
        this.biography = biography;
        return this;
    }
    @Override
    public IBooksBuilder setIsPublished(boolean published) {
        this.published = published;
        return this;
    }
    @Override
    public IBooksBuilder setEditorials(String editorials) {
        this.editorials = editorials;
        return this;
    }
    @Override
    public IBooksBuilder setViews(int views) {
        this.views = views;
        return this;
    }
    @Override
    public IBooksBuilder setSaves(int saves) {
        this.saves = saves;
        return this;
    }
    @Override
    public IBooksBuilder setDownloads(int downloads) {
        this.downloads = downloads;
        return this;
    }
    @Override
    public IBooksBuilder setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }
    @Override
    public IBooksBuilder setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public Books build() {
        return new Books(id, name, nameId, description, biography, published, editorials, views, saves, downloads, createdAt, updatedAt);
    }
}
