package sh.losti.app.models;

public class Authors {
    private int id;
    private String name;
    private String nameId;
    private String description;
    private String imageUrl;
    private String[] genresList;
    private String lastWorkId;
    private String editorialId;

    public Authors(int id, String name, String nameId, String description, String imageUrl, String[] genresList, String lastWorkId, String editorialId) {
        this.id = id;
        this.name = name;
        this.nameId = nameId;
        this.description = description;
        this.imageUrl = imageUrl;
        this.genresList = genresList;
        this.lastWorkId = lastWorkId;
        this.editorialId = editorialId;
    }
}
