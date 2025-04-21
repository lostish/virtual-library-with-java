package sh.losti.app.models;

import sh.losti.app.enums.EBookDownloadType;
import sh.losti.app.enums.EBookPostType;
import sh.losti.app.enums.EBookState;

import java.util.Date;

public class Book {
    private int id;
    private int authorId; // author id (user relationship)
    private String name; // book name
    private String nameId; // auto-generate
    private String description; // book description
    private boolean published; // trigger
    private EBookState state; // enums
    private EBookPostType postType; // enums
    private EBookDownloadType downloadType; // enums
    private Date createdAt; // default of db
    private Date updatedAt; // default of db

    public Book(
            int id,
            int authorId,
            String name,
            String nameId,
            String description,
            boolean published,
            EBookState state,
            EBookPostType postType,
            EBookDownloadType downloadType,
            Date createdAt,
            Date updatedAt
    ) {
        this.id = id;
        this.authorId = authorId;
        this.name = name;
        this.nameId = nameId;
        this.description = description;
        this.published = published;
        this.state = state;
        this.postType = postType;
        this.downloadType = downloadType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
