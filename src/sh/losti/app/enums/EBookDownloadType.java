package sh.losti.app.enums;

public enum EBookDownloadType {
    OPEN,
    MEMBERS_ONLY,
    PAID;

    @Override
    public String toString() {
        return name();
    }
}
