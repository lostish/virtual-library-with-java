package sh.losti.app.interfaces.services;

import sh.losti.app.models.Session;
import sh.losti.app.models.SessionData;

public interface IAuthServices {
    boolean isValidSession(Session session);
    boolean isValidEmail(String email);
    boolean isValidPassword(String password);
    Session getSession();
    boolean setSession(Session session);
    SessionData getSessionData();
    String hashPassword(String password);
    boolean checkPassword(String password, String hashedPassword);
    boolean login(String email, String password);
    boolean signUp(String name, String email, String password);
    void logout();
}
