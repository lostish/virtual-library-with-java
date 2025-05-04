package sh.losti.app.models;

import java.util.Date;

public class Editorial {
    private int id;
    private String name;
    private String nameId;
    private String description;
    private String avatar;
    private String[] authorsIdList;
    private String[] genresIdList;
    private Date updatedAt;
    private Date createdAt;

    public Editorial(
            int id,
            String name,
            String nameId,
            String description,
            String avatar,
            String[] authorsIdList,
            String[] genresIdList,
            Date updatedAt,
            Date createdAt
    ) {
        this.id = id;
        this.name = name;
        this.nameId = nameId;
        this.description = description;
        this.avatar = avatar;
        this.authorsIdList = authorsIdList;
        this.genresIdList = genresIdList;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
}
