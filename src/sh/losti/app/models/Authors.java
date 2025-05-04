package sh.losti.app.models;

public class Authors {
    private int id;
    private int userId;
    private int lastWorkId;
    private int editorialId;

    public Authors(
            int id,
            int userId,
            int lastWorkId,
            int editorialId
    ) {
        this.id = id;
        this.lastWorkId = lastWorkId;
        this.editorialId = editorialId;
    }
}
