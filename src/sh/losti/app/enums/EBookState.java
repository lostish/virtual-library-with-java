package sh.losti.app.enums;

public enum EBookState {
    EMISSION,
    HIATUS,
    DROPPED,
    FINISHED;

    @Override
    public String toString() {
        return name();
    }
}
