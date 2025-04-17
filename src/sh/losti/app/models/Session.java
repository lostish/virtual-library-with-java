package sh.losti.app.models;

public class Session {
    private int id;
    private String name;
    private String nameId;
    private String email;

    public Session(int id, String name, String nameId, String email) {
        this.id = id;
        this.name = name;
        this.nameId = nameId;
        this.email = email;
    }
}
