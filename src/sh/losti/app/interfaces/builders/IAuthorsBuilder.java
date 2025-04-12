package sh.losti.app.interfaces.builders;

import sh.losti.app.models.Authors;

public interface IAuthorsBuilder {
    IAuthorsBuilder setId(int id);
    IAuthorsBuilder setName(String name);
    IAuthorsBuilder setNameId(String nameId);
    IAuthorsBuilder setDescription(String description);
    IAuthorsBuilder setImageUrl(String imageUrl);
    IAuthorsBuilder setGenresList(String[] genresList);
    IAuthorsBuilder setLastWorkId(String lastWorkId);
    IAuthorsBuilder setEditorialId(String editorialId);
    Authors build();
}
