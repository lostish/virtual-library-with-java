package sh.losti.app.interfaces.builders;

import sh.losti.app.models.Authors;

public interface IAuthorsBuilder {
    int getId();

    int getUserId();

    int getLastWorkId();

    int getEditorialId();

    IAuthorsBuilder setId(int id);

    IAuthorsBuilder setUserId(int userId);

    IAuthorsBuilder setLastWorkId(int lastWorkId);

    IAuthorsBuilder setEditorialId(int editorialId);

    Authors build();
}
