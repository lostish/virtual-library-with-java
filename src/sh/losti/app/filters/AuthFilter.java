package sh.losti.app.filters;

import sh.losti.app.interfaces.services.IAuthServices;
import sh.losti.app.models.Session;
import sh.losti.app.services.AuthServices;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    private final IAuthServices auth = AuthServices.getInstance();

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String path = request.getRequestURI();
        Session session = null;

        // boolean isAuthRoute = path.startsWith("/auth/");
        boolean isSignIn = path.equals("/auth/sign-in");
        boolean isSignUp = path.equals("/auth/sign-up");
        boolean isAccount = path.equals("/auth/account");

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("session".equals(cookie.getName())) {
                    session = Session.fromJson(cookie.getValue());
                    break;
                }
            }
        }

        boolean isLoggedIn = session != null && auth.isValidSession(session);

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
