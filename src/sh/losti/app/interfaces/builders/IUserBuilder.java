package sh.losti.app.interfaces.builders;

import sh.losti.app.models.User;

import java.util.Date;

public interface IUserBuilder {
    IUserBuilder setId(int id);
    IUserBuilder setName(String name);
    IUserBuilder setNameId(String nameId);
    IUserBuilder setEmail(String email);
    IUserBuilder setPassword(String password);
    IUserBuilder setCreatedAt(Date createdAt);
    IUserBuilder setUpdatedAt(Date updatedAt);
    User build();
}
