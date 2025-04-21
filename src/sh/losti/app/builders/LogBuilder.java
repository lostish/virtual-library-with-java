package sh.losti.app.builders;

import sh.losti.app.enums.ELogLevel;
import sh.losti.app.interfaces.builders.ILogBuilder;
import sh.losti.app.models.Log;

public class LogBuilder implements ILogBuilder {
    private ELogLevel level;
    private String by;
    private String action;
    private String message;
    private String data;
    private String errors;
    private String location;
    private long timestamp;
    private long duration;

    @Override
    public ELogLevel getLogLevel() {
        return level;
    }

    @Override
    public ILogBuilder setLevel(ELogLevel level) {
        this.level = level;
        return this;
    }

    @Override
    public String getBy() {
        return by;
    }

    @Override
    public ILogBuilder setBy(String by) {
        this.by = by;
        return this;
    }

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public ILogBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public ILogBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public ILogBuilder setData(String data) {
        this.data = data;
        return this;
    }

    @Override
    public String getErrors() {
        return errors;
    }

    @Override
    public ILogBuilder setErrors(String errors) {
        this.errors = errors;
        return this;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public ILogBuilder setLocation(Throwable throwable) {
        if (throwable != null && throwable.getStackTrace().length > 0) {
            StackTraceElement elem = throwable.getStackTrace()[0];
            this.location = elem.getClassName() + "." + elem.getMethodName() +
                    "(" + elem.getFileName() + ":" + elem.getLineNumber() + ")";
        }
        return this;
    }

    @Override
    public long getLocalTimestamp() {
        return timestamp;
    }

    @Override
    public ILogBuilder setLocalTimestamp(long time) {
        this.timestamp = time;
        return this;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    @Override
    public ILogBuilder setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public String formatLog() {
        return String.format(
                "[%s] [%s] [%s] %s @ %d (%s) [duration=%dms]",
                level.toString(),
                by,
                action,
                message,
                timestamp,
                location != null ? location : "unknown",
                duration
        );
    }

    @Override
    public Log build() {
        return new Log(
                level,
                by,
                action,
                message,
                data,
                errors,
                location,
                timestamp,
                duration
        );
    };
}
