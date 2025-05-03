package sh.losti.app.builders;

import sh.losti.app.interfaces.builders.IAuthorsBuilder;
import sh.losti.app.models.Authors;

public class AuthorsBuilder implements IAuthorsBuilder {
    private int id;
    private int userId;
    private int lastWorkId;
    private int editorialId;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public int getLastWorkId() {
        return lastWorkId;
    }

    @Override
    public int getEditorialId() {
        return editorialId;
    }

    @Override
    public IAuthorsBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public IAuthorsBuilder setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public IAuthorsBuilder setLastWorkId(int lastWorkId) {
        this.lastWorkId = lastWorkId;
        return this;
    }

    @Override
    public IAuthorsBuilder setEditorialId(int editorialId) {
        this.editorialId = editorialId;
        return this;
    }

    @Override
    public Authors build() {
        return new Authors(id, userId, lastWorkId, editorialId);
    }
}