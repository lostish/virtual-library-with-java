package sh.losti.app.constants;

public class AuthConstants {
    private static final String[] authCookies = new String[]{"session", "session-data"};
    private static final String accountPath = "/account";
    private static final String sortSettingsPath = "/settings";
    private static final String signInPath = "/auth/sign-in";
    private static final String signUpPath = "/auth/sign-up";
    private static final String regexAdmitResources = ".*\\.(css|js|png|jpg|jpeg|gif|svg|woff2?|ttf|eot|html)$";

    public static String[] getAuthCookies() {
        return authCookies;
    }
    public static String getAccountPath() {
        return accountPath;
    }
    public static String getSortSettingsPath() {
        return sortSettingsPath;
    }
    public static String getSignInPath() {
        return signInPath;
    }
    public static String getSignUpPath() {
        return signUpPath;
    }
    public static String getRegexAdmitResources() {
        return regexAdmitResources;
    }

    private AuthConstants() {}
}
