package sh.losti.app.constants;

import java.util.regex.Pattern;

public class AuthConstants {
    private static final String[] authCookies = new String[]{"session", "session-data"};
    private static final String accountPath = "/account";
    private static final String sortSettingsPath = "/settings";
    private static final String signInPath = "/auth/sign-in";
    private static final String signUpPath = "/auth/sign-up";
    private static final String regexAdmitResources = ".*\\.(css|js|png|jpg|jpeg|gif|svg|woff2?|ttf|eot|html)$";
    private static final Pattern EMAIL_REGEX = Pattern.compile(
            "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern PASSWORD_REGEX = Pattern
            .compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");


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
    public static Pattern getEmailRegex() { return EMAIL_REGEX; };
    public static Pattern getPasswordRegex() { return PASSWORD_REGEX; };

    private AuthConstants() {}
}
