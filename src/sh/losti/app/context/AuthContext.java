package sh.losti.app.context;

import sh.losti.app.models.Session;
import sh.losti.app.models.SessionData;

public class AuthContext {
    private final Session session;
    private final SessionData sessionData;

    public AuthContext(Session session, SessionData sessionData) {
        this.session = session;
        this.sessionData = sessionData;
    }

    public Session getSession() {
        return session;
    }

    public SessionData getSessionData() {
        return sessionData;
    }

    public int getUserId() {
        return sessionData.getId();
    }

    public String getUserEmail() {
        return sessionData.getEmail();
    }

    public String getUserName() {
        return sessionData.getName();
    }

    public String getUserNameId() {
        return sessionData.getNameId();
    }

}
