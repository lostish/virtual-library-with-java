package sh.losti.app.interfaces.builders;

import sh.losti.app.enums.EBookDownloadType;
import sh.losti.app.enums.EBookPostType;
import sh.losti.app.enums.EBookState;
import sh.losti.app.models.Book;

import java.util.Date;

public interface IBookBuilder {
    IBookBuilder setId(int id);
    IBookBuilder setAuthorId(int authorId);
    IBookBuilder setName(String name);
    IBookBuilder setNameId(String nameId);
    IBookBuilder setDescription(String description);
    IBookBuilder setIsPublished(boolean published);
    IBookBuilder seState(EBookState state);
    IBookBuilder setPostType(EBookPostType postType);
    IBookBuilder setDownloadType(EBookDownloadType downloadType);
    IBookBuilder setCreatedAt(Date createdAt);
    IBookBuilder setUpdatedAt(Date updatedAt);
    Book build();
}
