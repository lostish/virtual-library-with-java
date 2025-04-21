package sh.losti.app.models;

import sh.losti.app.enums.EUserRole;
import sh.losti.app.enums.EUserState;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String nameId;
    private String email;
    private String password;
    private EUserState state;
    private EUserRole role;
    private Date lastLogin;
    private Date createdAt;
    private Date updatedAt;

    public User(
            int id,
            String name,
            String nameId,
            String email,
            String password,
            Date createdAt,
            Date updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.nameId = nameId;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
