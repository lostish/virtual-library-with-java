package sh.losti.app.models;

import org.json.JSONObject;

public class SessionData {
    private int id;
    private String name;
    private String nameId;
    private String email;

    public SessionData(int id, String name, String nameId, String email) {
        this.id = id;
        this.name = name;
        this.nameId = nameId;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNameId() {
        return nameId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("name", name);
        json.put("nameId", nameId);
        json.put("email", email);
        return json.toString();
    }

    public static SessionData fromJSON(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            return new SessionData(
                    json.getInt("id"),
                    json.getString("name"),
                    json.getString("nameId"),
                    json.getString("email")
            );
        } catch (Exception e) {
            return null;
        }
    }
}
