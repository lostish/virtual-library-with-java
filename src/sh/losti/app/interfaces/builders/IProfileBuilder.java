package sh.losti.app.interfaces.builders;

import sh.losti.app.models.Profile;

import java.util.Date;

public interface IProfileBuilder {
    IProfileBuilder setId(String id);
    IProfileBuilder setUserId(String userId);
    IProfileBuilder setBiography(String biography);
    IProfileBuilder setNetworks(String networks);
    IProfileBuilder setBooks(String books);
    IProfileBuilder setCreatedAt(Date createdAt);
    IProfileBuilder setUpdatedAt(Date updatedAt);
    Profile build();
}
