package sh.losti.app.models;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String nameId;
    private String email;
    private String password;
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
