package sh.losti.app.interfaces.builders;

import sh.losti.app.models.Books;

import java.util.Date;

public interface IBooksBuilder {
    IBooksBuilder setId(String id);
    IBooksBuilder setName(String name);
    IBooksBuilder setNameId(String nameId);
    IBooksBuilder setDescription(String description);
    IBooksBuilder setBiography(String biography);
    IBooksBuilder setIsPublished(boolean published);
    IBooksBuilder setEditorials(String editorials);
    IBooksBuilder setViews(int views);
    IBooksBuilder setSaves(int saves);
    IBooksBuilder setDownloads(int downloads);
    IBooksBuilder setCreatedAt(Date createdAt);
    IBooksBuilder setUpdatedAt(Date updatedAt);
    Books build();
}
