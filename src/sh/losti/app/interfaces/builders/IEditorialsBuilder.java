package sh.losti.app.interfaces.builders;

import sh.losti.app.models.Editorials;

import java.util.Date;

public interface IEditorialsBuilder {
    IEditorialsBuilder setId(int id);
    IEditorialsBuilder setName(String name);
    IEditorialsBuilder setNameId(String nameId);
    IEditorialsBuilder setDescription(String description);
    IEditorialsBuilder setAvatar(String avatar);
    IEditorialsBuilder setAuthorsIdList(String[] authorsIdList);
    IEditorialsBuilder setGenresIdList(String[] genresIdList);
    IEditorialsBuilder setUpdatedAt(Date updatedAt);
    IEditorialsBuilder setCreatedAt(Date createdAt);
    Editorials build();
}
