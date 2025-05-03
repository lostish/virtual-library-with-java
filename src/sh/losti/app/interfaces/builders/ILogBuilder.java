package sh.losti.app.interfaces.builders;

import sh.losti.app.enums.ELogLevel;
import sh.losti.app.models.Log;

public interface ILogBuilder {
    ELogLevel getLogLevel();
    ILogBuilder setLevel(ELogLevel level);
    String getCreateBy();
    ILogBuilder setCreateBy(String createBy);
    String getAction();
    ILogBuilder setAction(String action);
    String getMessage();
    ILogBuilder setMessage(String message);
    String getData();
    ILogBuilder setData(String data);
    String getErrors();
    ILogBuilder setErrors(String errors);
    String getLocation();
    ILogBuilder setLocation(Throwable throwable);
    long getLocalTimestamp();
    ILogBuilder setLocalTimestamp(long time);
    long getDuration();
    ILogBuilder setDuration(long duration);
    String formatLog();
    Log build();
}
