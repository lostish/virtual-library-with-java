package sh.losti.app.enums;

public enum EUserState {
    ACTIVE,
    INACTIVE,
    DELETED;

    @Override
    public String toString() {
        return name();
    }
}
