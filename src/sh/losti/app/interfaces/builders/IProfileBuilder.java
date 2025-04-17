package sh.losti.app.interfaces.builders;

import java.util.Date;
import sh.losti.app.models.Profile;

public interface IProfileBuilder {
    IProfileBuilder setId(int id);

    IProfileBuilder setUserId(int userId);

    IProfileBuilder setBiography(String biography);

    IProfileBuilder setNetworks(String networks);

    IProfileBuilder setBooks(String books);

    IProfileBuilder setCreatedAt(Date createdAt);

    IProfileBuilder setUpdatedAt(Date updatedAt);

    Profile build();
}
