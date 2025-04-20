package sh.losti.app.models;

import sh.losti.app.enums.ELogLevel;

public class Log {
    private ELogLevel level;
    private String by;
    private String action;
    private String message;
    private String data;
    private String errors;
    private String location;
    private long timestamp; // = System.currentTimeMillis();
    private long duration;

    public Log(
            ELogLevel level,
            String by,
            String action,
            String message,
            String data,
            String errors,
            String location,
            long timestamp,
            long duration
    ) {
        this.level = level;
        this.by = by;
        this.action = action;
        this.message = message;
        this.data = data;
        this.errors = errors;
        this.location = location;
        this.timestamp = timestamp;
        this.duration = duration;
    }
}
