package sh.losti.app.interfaces.builders;

import java.util.Date;
import sh.losti.app.models.Profile;

public interface IProfileBuilder {
    IProfileBuilder setId(int id);
    int getId();
    IProfileBuilder setUserId(int userId);
    int getUserId();
    IProfileBuilder setLWNameId(String lastWorkNameId);
    String getLWNameId();
    IProfileBuilder setLENameId(String editorialNameId);
    String getLENameId();
    IProfileBuilder setBiography(String biography);
    String getBiography();
    IProfileBuilder setCreatedAt(Date createdAt);
    Date getCreatedAt();
    IProfileBuilder setUpdatedAt(Date updatedAt);
    Date getUpdatedAt();
    Profile build();
}
