package sh.losti.app.builders;

import sh.losti.app.interfaces.builders.IUserBuilder;
import sh.losti.app.models.User;

import java.util.Date;

public class UserBuilder implements IUserBuilder {
    private String id;
    private String name;
    private String nameId;
    private String password;
    private Date createdAt;
    private Date updatedAt;

    @Override
    public IUserBuilder setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public IUserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IUserBuilder setNameId(String nameId) {
        this.nameId = nameId;
        return this;
    }

    @Override
    public IUserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public IUserBuilder setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public IUserBuilder setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public User build() {
        return new User(id, name, nameId, password, createdAt, updatedAt);
    }
}
