package sh.losti.app.builders;

import sh.losti.app.interfaces.builders.IEditorialBuilder;
import sh.losti.app.models.Editorial;

import java.util.Date;

public class EditorialBuilder implements IEditorialBuilder {
    private int id;
    private String name;
    private String nameId;
    private String description;
    private String avatar;
    private String[] authorsIdList;
    private String[] genresIdList;
    private Date updatedAt;
    private Date createdAt;

    @Override
    public IEditorialBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public IEditorialBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IEditorialBuilder setNameId(String nameId) {
        this.nameId = nameId;
        return this;
    }

    @Override
    public IEditorialBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public IEditorialBuilder setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    @Override
    public IEditorialBuilder setAuthorsIdList(String[] authorsIdList) {
        this.authorsIdList = authorsIdList;
        return this;
    }

    @Override
    public IEditorialBuilder setGenresIdList(String[] genresIdList) {
        this.genresIdList = genresIdList;
        return this;
    }

    @Override
    public IEditorialBuilder setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public IEditorialBuilder setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public Editorial build() {
        return new Editorial(id, name, nameId, description, avatar, authorsIdList, genresIdList, updatedAt, createdAt);
    }
}
