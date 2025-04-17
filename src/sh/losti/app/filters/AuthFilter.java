package sh.losti.app.filters;

import sh.losti.app.models.Session;
import sh.losti.app.services.AuthServices;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    private AuthServices auth = null;

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
