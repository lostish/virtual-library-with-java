package sh.losti.app.services;

import sh.losti.app.dao.UserDaoImpl;
import sh.losti.app.interfaces.services.IUserServices;
import sh.losti.app.models.Profile;

import java.util.logging.Logger;

public class UserServices implements IUserServices {
    private static final Logger logger = Logger.getLogger(UserServices.class.getName());
    private static UserServices instance;
    private static final UserDaoImpl dao = UserDaoImpl.getInstance();

    private UserServices() {}

    public static synchronized UserServices getInstance() {
        if (instance == null) {
            instance = new UserServices();
        }
        return instance;
    }

    @Override
    public Profile getProfileData(int id) {
        return dao.getProfile(id);
    }
}
