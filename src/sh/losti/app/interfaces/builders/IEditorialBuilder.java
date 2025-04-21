package sh.losti.app.interfaces.builders;

import sh.losti.app.models.Editorial;

import java.util.Date;

public interface IEditorialBuilder {
    IEditorialBuilder setId(int id);
    IEditorialBuilder setName(String name);
    IEditorialBuilder setNameId(String nameId);
    IEditorialBuilder setDescription(String description);
    IEditorialBuilder setAvatar(String avatar);
    IEditorialBuilder setAuthorsIdList(String[] authorsIdList);
    IEditorialBuilder setGenresIdList(String[] genresIdList);
    IEditorialBuilder setUpdatedAt(Date updatedAt);
    IEditorialBuilder setCreatedAt(Date createdAt);
    Editorial build();
}
