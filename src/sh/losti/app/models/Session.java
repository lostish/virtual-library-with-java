package sh.losti.app.models;

import org.json.JSONObject;

import java.util.Date;

public class Session {
    private int session_id;
    private int user_id;
    private String session_key;
    private Date created_at;
    private Date expires_at;

    public Session(
            int id,
            int user_id,
            String session_key,
            Date created_at,
            Date expires_at) {
        this.session_id = id;
        this.user_id = user_id;
        this.session_key = session_key;
        this.created_at = created_at;
        this.expires_at = expires_at;
    }

    public String getSessionKey() {
        return session_key;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("session_id", session_id);
        json.put("user_id", user_id);
        json.put("session_key", session_key);
        json.put("created_at", created_at != null ? created_at.getTime() : null);
        json.put("expires_at", expires_at != null ? expires_at.getTime() : null);
        return json.toString();
    }

    public static Session fromJson(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            return new Session(
                    json.getInt("session_id"),
                    json.getInt("user_id"),
                    json.getString("session_key"),
                    json.has("expires_at") && !json.isNull("expires_at")
                            ? new Date(json.getLong("expires_at"))
                            : null);
        } catch (Exception e) {
            return null;
        }
    }
}
