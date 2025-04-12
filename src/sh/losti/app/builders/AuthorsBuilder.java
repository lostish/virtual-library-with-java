package sh.losti.app.builders;

import sh.losti.app.interfaces.builders.IAuthorsBuilder;
import sh.losti.app.models.Authors;

public class AuthorsBuilder implements IAuthorsBuilder {
    private int id;
    private String name;
    private String nameId;
    private String description;
    private String imageUrl;
    private String[] genresList;
    private String lastWorkId;
    private String editorialId;

    @Override
    public IAuthorsBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public IAuthorsBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IAuthorsBuilder setNameId(String nameId) {
        this.nameId = nameId;
        return this;
    }

    @Override
    public IAuthorsBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public IAuthorsBuilder setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public IAuthorsBuilder setGenresList(String[] genresList) {
        this.genresList = genresList;
        return this;
    }

    @Override
    public IAuthorsBuilder setLastWorkId(String lastWorkId) {
        this.lastWorkId = lastWorkId;
        return this;
    }

    @Override
    public IAuthorsBuilder setEditorialId(String editorialId) {
        this.editorialId = editorialId;
        return this;
    }

    @Override
    public Authors build() {
        return new Authors(id, name, nameId, description, imageUrl, genresList, lastWorkId, editorialId);
    }
}
