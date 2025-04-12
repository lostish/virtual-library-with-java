package sh.losti.app.builders;

import sh.losti.app.interfaces.builders.IEditorialsBuilder;
import sh.losti.app.models.Editorials;

import java.util.Date;

public class EditorialsBuilder implements IEditorialsBuilder {
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
    public IEditorialsBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public IEditorialsBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IEditorialsBuilder setNameId(String nameId) {
        this.nameId = nameId;
        return this;
    }

    @Override
    public IEditorialsBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public IEditorialsBuilder setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    @Override
    public IEditorialsBuilder setAuthorsIdList(String[] authorsIdList) {
        this.authorsIdList = authorsIdList;
        return this;
    }

    @Override
    public IEditorialsBuilder setGenresIdList(String[] genresIdList) {
        this.genresIdList = genresIdList;
        return this;
    }

    @Override
    public IEditorialsBuilder setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public IEditorialsBuilder setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public Editorials build() {
        return new Editorials(id, name, nameId, description, avatar, authorsIdList, genresIdList, updatedAt, createdAt);
    }
}
