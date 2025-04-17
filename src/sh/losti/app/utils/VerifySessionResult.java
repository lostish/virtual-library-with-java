package sh.losti.app.utils;

import sh.losti.app.enums.EVerifySessionData;
import sh.losti.app.models.SessionData;

public class VerifySessionResult {
    private final EVerifySessionData status;
    private final SessionData sessionData;

    public VerifySessionResult(EVerifySessionData status, SessionData sessionData) {
        this.status = status;
        this.sessionData = sessionData;
    }

    public EVerifySessionData getStatus() {
        return status;
    }

    public SessionData getSessionData() {
        return sessionData;
    }
}
