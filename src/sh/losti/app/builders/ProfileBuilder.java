package sh.losti.app.builders;

import sh.losti.app.interfaces.builders.IProfileBuilder;
import sh.losti.app.models.Profile;

import java.util.Date;

public class ProfileBuilder implements IProfileBuilder {
    private int id;
    private String userId;
    private String biography;
    private String networks;
    private String books;
    private Date createdAt;
    private Date updatedAt;
    @Override
    public IProfileBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public IProfileBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public IProfileBuilder setBiography(String biography) {
        this.biography = biography;
        return this;
    }

    @Override
    public IProfileBuilder setNetworks(String networks) {
        this.networks = networks;
        return this;
    }

    @Override
    public IProfileBuilder setBooks(String books) {
        this.books = books;
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
        return new Profile(id, userId, biography, networks, books, createdAt, updatedAt);
    }
}
