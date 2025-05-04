package sh.losti.app.interfaces.dao;

import sh.losti.app.models.Session;
import sh.losti.app.models.SessionData;
import sh.losti.app.utils.VerifySessionResult;

import java.sql.ResultSet;

public interface IDaoAuth {
    boolean createUser(String name, String nameId, String email, String password);
    String getHashedPassword(String email);
    void updateHashedPassword(String email, String newPwd);
    ResultSet verifySession(Session session);
    VerifySessionResult verifySessionData(SessionData currentSessionData);
    SessionData  getSessionData(String email);
    void createSession(int id, String email);
    Session getSession(String email);
    void deleteSession(String key);
}
