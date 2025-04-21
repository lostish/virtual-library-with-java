package sh.losti.app.models;

public class Authors {
    private int id;
    private String[] genresList;
    private String lastWorkId;
    private String editorialId;

    public Authors(
            int id,
            String name,
            String nameId,
            String description,
            String imageUrl,
            String[] genresList,
            String lastWorkId,
            String editorialId
    ) {
        this.id = id;
        this.genresList = genresList;
        this.lastWorkId = lastWorkId;
        this.editorialId = editorialId;
    }
}
