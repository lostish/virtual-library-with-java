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

@WebFilter("/*")
public class AuthFilter implements Filter {
    private AuthServices auth = null;
    private static final String accountPath = "/account";
    private static final String sortSettingsPath = "/settings";
    private static final String signInPath = "/auth/sign-in";
    private static final String signUpPath = "/auth/sign-up";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        auth = AuthServices.getInstance();
        System.out.println("[AuthFilter] Inicializado");
    }

    @Override
    public void destroy() {
        System.out.println("[AuthFilter] Destruido");
        auth = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String ctx = req.getContextPath();
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();

        Session session = null;
        SessionData sessionData = null;

        // Construir la ruta completa
        String fullPath = (servletPath + (pathInfo != null ? pathInfo : "")).toLowerCase();

        // Si es una ruta pública bajo /account/of/, permitir el acceso
        if (fullPath.matches("/account/of/[a-z0-9_-]+")) {
            chain.doFilter(req, res);
            return;
        }

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (AuthConstants.authCookies[0].equals(cookie.getName())) {
                    session = Session.fromJson(cookie.getValue());
                }
                if (AuthConstants.authCookies[1].equals(cookie.getName())) {
                    sessionData = SessionData.fromJSON(cookie.getValue());
                }
            }
        }

        boolean isLoggedIn = session != null && auth.isValidSession(session);
        VerifySessionResult vsr = auth.verifySessionData(sessionData);

        boolean wantsAccountBase    = accountPath.equals(servletPath)   && (pathInfo == null || "/".equals(pathInfo));
        boolean wantsAccountSetting = accountPath.equals(servletPath)   && sortSettingsPath.equals(pathInfo);

        boolean wantsSignIn = signInPath.equals(servletPath);
        boolean wantsSignUp = signUpPath.equals(servletPath);

        if (isLoggedIn && vsr.getStatus() == EVerifySessionData.UPDATED) {
            SessionData fresh = vsr.getSessionData();
            Cookie sdCookie = new Cookie("session-data", fresh.toString());
            sdCookie.setPath("/");
            sdCookie.setHttpOnly(true);
            sdCookie.setMaxAge(3 * 24 * 60 * 60); // 3 días
            res.addCookie(sdCookie);
        }

        if (!isLoggedIn && (wantsAccountBase || wantsAccountSetting)) {
            res.sendRedirect(ctx + signInPath);
            return;
        }

        if (isLoggedIn && (wantsSignIn || wantsSignUp)) {
            res.sendRedirect(ctx + accountPath);
            return;
        }

        chain.doFilter(req, res);
    }
}
