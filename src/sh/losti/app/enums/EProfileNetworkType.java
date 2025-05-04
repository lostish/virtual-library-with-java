package sh.losti.app.enums;

public enum EProfileNetworkType {
    NONE,
    SOCIAL,
    WORK;

    @Override
    public String toString() {
        return name();
    }
}
