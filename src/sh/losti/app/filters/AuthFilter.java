package sh.losti.app.filters;

import sh.losti.app.constants.AuthConstants;
import sh.losti.app.enums.EVerifySessionData;
import sh.losti.app.models.Session;
import sh.losti.app.models.SessionData;
import sh.losti.app.services.AuthServices;
import sh.losti.app.utils.VerifySessionResult;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter("/*")
public class AuthFilter implements Filter {
    private AuthServices auth = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            System.out.println("[DEBUG] Llamando a AuthServices.getInstance()");
            auth = AuthServices.getInstance();
            System.out.println("[DEBUG] AuthServices inicializado OK");
        } catch(Exception e) {
            e.fillInStackTrace(); // o usa tu logger
            throw new ServletException("AuthFilter init failed", e);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String ctx = req.getContextPath();
        String path = req.getRequestURI()
                .substring(req.getContextPath().length());

        Session session = null;
        SessionData sessionData = null;

        // Si es una ruta pública bajo /account/of/, permitir el acceso
        if (path.matches("/account/of/[a-z0-9_-]+")) {
            chain.doFilter(req, res);
            return;
        }

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (AuthConstants.getAuthCookies()[0].equals(cookie.getName())) {
                    session = Session.fromJson(cookie.getValue());
                }
                if (AuthConstants.getAuthCookies()[1].equals(cookie.getName())) {
                    sessionData = SessionData.fromJSON(cookie.getValue());
                }
            }
        }

        boolean isLoggedIn = session != null && auth.isValidSession(session);
        VerifySessionResult vsr = auth.verifySessionData(sessionData);

        boolean wantsAccount = AuthConstants.getAccountPath().equals(path);
        boolean wantsAccountSetting = AuthConstants.getSortSettingsPath().equals(path);
        boolean wantsSignIn = AuthConstants.getSignInPath().equals(path);
        boolean wantsSignUp = AuthConstants.getSignUpPath().equals(path);

        if (path.equals("/") || path.isEmpty()) {
            chain.doFilter(request, response);
            return;
        }

        if (Pattern.matches(AuthConstants.getRegexAdmitResources(), path)) {
            chain.doFilter(request, response);
            return;
        }

        if (!isLoggedIn && (wantsAccount || wantsAccountSetting)) {
            res.sendRedirect(ctx + AuthConstants.getSignInPath());
            return;
        }

        if (isLoggedIn && vsr.getStatus() == EVerifySessionData.UPDATED) {
            SessionData fresh = vsr.getSessionData();
            Cookie sdCookie = new Cookie("session-data", fresh.toString());
            sdCookie.setPath("/");
            sdCookie.setHttpOnly(true);
            sdCookie.setMaxAge(3 * 24 * 60 * 60); // 3 días
            res.addCookie(sdCookie);
        }

        if (isLoggedIn && (wantsSignIn || wantsSignUp)) {
            res.sendRedirect(ctx + AuthConstants.getAccountPath());
            return;
        }

        chain.doFilter(req, res);
    }
}
