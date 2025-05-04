package sh.losti.app.enums;

public enum ELogLevel {
    FINE,
    SEVERE,
    CONFIG,
    ALL,
    INFO,
    WARNING,
    ERROR,
    DATABASE;

    @Override
    public String toString() {
        return name();
    }
}
