package sh.losti.app.filters;

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
    private static final String[] authCookies = new String[]{"session", "session-data"};

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
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String path = request.getRequestURI();
        Session session = null;
        SessionData sessionData = null;
        // boolean isAuthRoute = path.startsWith("/auth/");
        boolean isSignIn = path.equals("/auth/sign-in");
        boolean isSignUp = path.equals("/auth/sign-up");
        boolean isAccount = path.equals("/auth/account");

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (authCookies[0].equals(cookie.getName())) {
                    session = Session.fromJson(cookie.getValue());
                }
                if (authCookies[1].equals(cookie.getName())) {
                    sessionData = SessionData.fromJSON(cookie.getValue());
                }
            }
        }

        boolean isLoggedIn = session != null && auth.isValidSession(session);
        VerifySessionResult vsr = auth.verifySessionData(sessionData);

        if (isLoggedIn && vsr.getStatus() == EVerifySessionData.UPDATED) {
            SessionData fresh = vsr.getSessionData();
            Cookie sdCookie = new Cookie("session-data", fresh.toString());
            sdCookie.setPath("/");
            sdCookie.setHttpOnly(true);
            sdCookie.setMaxAge(3 * 24 * 60 * 60); // 3 días
            response.addCookie(sdCookie);
        }

        if (!isLoggedIn && isAccount) {
            // Si no está logueado y quiere entrar a /auth/account, lo redirigimos
            response.sendRedirect("/auth/sign-in");
            return;
        }

        if (isLoggedIn && (isSignIn || isSignUp)) {
            response.sendRedirect("/auth/account");
            return;
        }

        chain.doFilter(req, res);
    }
}
