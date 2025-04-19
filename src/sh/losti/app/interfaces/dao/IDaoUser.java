package sh.losti.app.interfaces.dao;

import sh.losti.app.models.Profile;


public interface IDaoUser {
    Profile getProfile(int id);
}