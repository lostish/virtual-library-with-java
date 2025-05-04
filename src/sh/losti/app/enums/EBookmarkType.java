package sh.losti.app.enums;

public enum EBookmarkType {
    COMPLETED,
    FAVORITE,
    PENDING,
    DROPPED;

    @Override
    public String toString() {
        return name();
    }
}
