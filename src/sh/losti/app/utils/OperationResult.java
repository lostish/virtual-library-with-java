package sh.losti.app.utils;

public class OperationResult<T> {
    private final boolean success;
    private final T data;
    private final String message;
    private final int errorCode;

    private OperationResult(boolean success, T data, String msg, int code) {
        this.success = success; this.data = data; this.message = msg; this.errorCode = code;
    }

    public static <T> OperationResult<T> ok(T data) {
        return new OperationResult<>(true, data, null, 0);
    }
    public static <T> OperationResult<T> fail(int errorCode, String msg) {
        return new OperationResult<>(false, null, msg, errorCode);
    }

    // getters...
    public boolean isSuccess() { return success; }
    public T getData() { return data; }
    public String getMessage() { return message; }
    public int getErrorCode() { return errorCode; }
}
