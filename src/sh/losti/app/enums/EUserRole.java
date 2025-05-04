package sh.losti.app.enums;

public enum EUserRole {
    ADMIN,
    HELPER,
    USER;

    @Override
    public String toString() {
        return name();
    }
}
