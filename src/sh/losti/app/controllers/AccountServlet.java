package sh.losti.app.controllers;

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

@WebServlet("/auth/account/*")
public class AccountServlet extends HttpServlet {
    private AuthServices auth = AuthServices.getInstance();
    private Session session = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null ||  pathInfo.startsWith("/")) {
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

            if (isLoggedIn) {
                res.setStatus(HttpServletResponse.SC_ACCEPTED);
                res.setHeader("Authentication", "AUTHORIZED");
                res.getWriter().write("");
                return;
            }

            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setHeader("Authentication", "UNAUTHORIZED");
            res.getWriter().write("");
            res.sendRedirect("/auth/sign-in");
        }

        res.setContentType("application/json");
        res.setStatus(HttpServletResponse.SC_OK);
        res.setHeader("Cache-Control", "cache");
        res.getWriter().write("");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Maneja las solicitudes POST si es necesario
        String pathInfo = req.getPathInfo();
        if (pathInfo == null ||  pathInfo.startsWith("/")) {

        }

    }
}