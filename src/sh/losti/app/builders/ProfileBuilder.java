package sh.losti.app.builders;

import java.util.Date;
import sh.losti.app.interfaces.builders.IProfileBuilder;
import sh.losti.app.models.Profile;

public class ProfileBuilder implements IProfileBuilder {
    private int id;
    private int userId;
    private String lastWorkNameId;
    private String editorialNameId;
    private String biography;
    private Date createdAt;
    private Date updatedAt;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public String getLWNameId() {
        return lastWorkNameId;
    }

    @Override
    public String getLENameId() {
        return editorialNameId;
    }

    @Override
    public String getBiography() {
        return biography;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public IProfileBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public IProfileBuilder setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public IProfileBuilder setLWNameId(String lastWorkNameId) {
        this.lastWorkNameId = lastWorkNameId;
        return this;
    }

    @Override
    public IProfileBuilder setLENameId(String editorialNameId) {
        this.editorialNameId = editorialNameId;
        return this;
    }

    @Override
    public IProfileBuilder setBiography(String biography) {
        this.biography = biography;
        return this;
    }

    @Override
    public IProfileBuilder setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public IProfileBuilder setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public Profile build() {
        return new Profile(id, userId, lastWorkNameId, editorialNameId, biography, createdAt, updatedAt);
    }
}
