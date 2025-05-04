package sh.losti.app.enums;

public enum EBookPostType {
    UNIQUE_EDITION,
    SAGA,
    SERIES,
    ANTHOLOGY,
    SERIAL_EDITION,
    SINGLE_ISSUE,
    TRADE_PAPERBACK,
    TPB,
    STORY_ARC,
    HARDCOVER,
    COMPILATION_VOLUME,
    WEB_COMIC,
    WEB_TOON,
    WEEKLY_POST,
    MONTHLY_POST,
    ONE_SHOT;

    @Override
    public String toString() {
        return name();
    }
}
