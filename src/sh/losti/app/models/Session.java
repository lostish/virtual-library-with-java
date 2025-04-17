package sh.losti.app.models;

import java.util.Date;

public class Session {
    private int session_id;
    private int user_id;
    private String session_key;
    private Date expires_at;

    public Session(
            int id,
            int user_id,
            String session_key,
            Date expires_at
    ) {
        this.session_id = id;
        this.user_id = user_id;
        this.session_key = session_key;
        this.expires_at = expires_at;
    }
}
