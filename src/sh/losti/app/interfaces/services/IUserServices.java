package sh.losti.app.interfaces.services;

import sh.losti.app.models.Profile;

import java.sql.SQLException;

public interface IUserServices {
    Profile getProfileData(int id) throws SQLException;
}
