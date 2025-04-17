package sh.losti.app.models;

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
}
