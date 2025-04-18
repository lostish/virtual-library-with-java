package sh.losti.app.servlets;

import sh.losti.app.constants.AuthConstants;
import sh.losti.app.models.Session;
import sh.losti.app.services.AuthServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/account/*")
public class AccountServlet extends HttpServlet {
    private final AuthServices auth = AuthServices.getInstance();
    private Session session = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        res.setContentType("application/json");

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            Arrays.stream(cookies)
                    .filter(cookie -> AuthConstants.authCookies[0].equals(cookie.getName()))
                    .findFirst()
                    .ifPresent(cookie -> {
                        session = Session.fromJson(cookie.getValue());
                    });
        }

        boolean isLoggedIn = session != null && auth.isValidSession(session);

        if (pathInfo != null ) {
            if (pathInfo.equals("/")) {
                if (isLoggedIn) {
                    res.setStatus(HttpServletResponse.SC_OK);
                    res.setHeader("Authentication", "AUTHORIZED");
                    res.getWriter().write("");
                    return;
                }

                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.setHeader("Authentication", "UNAUTHORIZED");
                res.sendRedirect(req.getContextPath() +  "/auth/sign-in");
            }

            if (pathInfo.equals("/settings")) {
                if (isLoggedIn) {
                    res.setStatus(HttpServletResponse.SC_OK);
                    res.setHeader("Authentication", "AUTHORIZED");
                    res.getWriter().write("");
                    return;
                }

                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.setHeader("Authentication", "UNAUTHORIZED");
                res.sendRedirect(req.getContextPath() + "/unauthorized");
            }

            if (pathInfo.equals("/of/")) {
                String username = pathInfo.substring(4);

                if (!username.isEmpty()) {
                    res.setStatus(HttpServletResponse.SC_OK);
                    res.setHeader("Cache-Control", "cache");
                    res.getWriter().write("");
                    return;
                }

                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.setHeader("Cache-Control", "cache");
                res.getWriter().write("");
            }

            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            res.setHeader("Cache-Control", "cache");
            res.sendRedirect(req.getContextPath() + "/not-found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Maneja las solicitudes POST si es necesario
        String pathInfo = req.getPathInfo();
        if (pathInfo == null ||  pathInfo.startsWith("/")) {

        }

    }
}