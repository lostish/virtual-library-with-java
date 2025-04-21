package sh.losti.app.builders;

import sh.losti.app.enums.EBookDownloadType;
import sh.losti.app.enums.EBookPostType;
import sh.losti.app.enums.EBookState;
import sh.losti.app.interfaces.builders.IBookBuilder;
import sh.losti.app.models.Book;

import java.util.Date;

public class BookBuilder implements IBookBuilder {
    private int id;
    private int authorId;
    private String name;
    private String nameId;
    private String description;
    private boolean published;
    private EBookState state;
    private EBookPostType postType;
    private EBookDownloadType downloadType;
    private Date createdAt;
    private Date updatedAt;

    @Override
    public IBookBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public IBookBuilder setAuthorId(int authorId) {
        this.authorId = authorId;
        return this;
    }

    @Override
    public IBookBuilder setName(String name) {
        this.name = name;
        return this;
    }
    @Override
    public IBookBuilder setNameId(String nameId) {
        this.nameId = nameId;
        return this;
    }
    @Override
    public IBookBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public IBookBuilder setIsPublished(boolean published) {
        this.published = published;
        return this;
    }

    @Override
    public IBookBuilder seState(EBookState state) {
        this.state = state;
        return this;
    }

    @Override
    public IBookBuilder setPostType(EBookPostType postType) {
        this.postType = postType;
        return this;
    }

    @Override
    public IBookBuilder setDownloadType(EBookDownloadType downloadType) {
        this.downloadType = downloadType;
        return this;
    }


    @Override
    public IBookBuilder setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }
    @Override
    public IBookBuilder setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public Book build() {
        return new Book(
                id,
                authorId,
                name,
                nameId,
                description,
                published,
                state,
                postType,
                downloadType,
                createdAt,
                updatedAt
        );
    }
}
