package sh.losti.app.interfaces.builders;

import sh.losti.app.enums.EUserRole;
import sh.losti.app.enums.EUserState;
import sh.losti.app.models.User;

import java.util.Date;

public interface IUserBuilder {
    IUserBuilder setId(int id);
    IUserBuilder setName(String name);
    IUserBuilder setNameId(String nameId);
    IUserBuilder setEmail(String email);
    IUserBuilder setPassword(String password);
    IUserBuilder setState(EUserState state);
    IUserBuilder setRole(EUserRole role);
    IUserBuilder setLastLogin(Date lastLogin);
    IUserBuilder setCreatedAt(Date createdAt);
    IUserBuilder setUpdatedAt(Date updatedAt);
    User build();
}
