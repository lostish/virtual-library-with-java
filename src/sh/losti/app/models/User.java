package sh.losti.app.models;

import java.util.Date;

public class User {
    private String id;
    private String name;
    private String nameId;
    private String password;
    private Date createdAt;
    private Date updatedAt;

    public User(String id, String name, String nameId, String password, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.nameId = nameId;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
