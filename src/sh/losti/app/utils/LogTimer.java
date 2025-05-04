package sh.losti.app.utils;

public class LogTimer {
    private final long start;

    private LogTimer() {
        this.start = System.nanoTime();
    }

    public static LogTimer start() {
        return new LogTimer();
    }

    public long millis() {
        return (System.nanoTime() - start) / 1_000_000;
    }
}

