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
        String ctx = req.getContextPath();

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            Arrays.stream(cookies)
                    .filter(cookie -> AuthConstants.authCookies[0].equals(cookie.getName()))
                    .findFirst()
                    .ifPresent(cookie -> session = Session.fromJson(cookie.getValue()));
        }

        boolean isLoggedIn = session != null && auth.isValidSession(session);

        if (pathInfo != null && pathInfo.equals("/of/")) {
            handlePublicProfile(req, res);
            return;
        }

        if ((pathInfo == null || pathInfo.equals("/")) && isLoggedIn) {
            res.setStatus(HttpServletResponse.SC_OK);
            res.setHeader("Authentication", "AUTHORIZED");
            res.getWriter().write("");
            return;
        }

        if (pathInfo != null && pathInfo.equals("/settings") && isLoggedIn) {
            res.setStatus(HttpServletResponse.SC_OK);
            res.setHeader("Authentication", "AUTHORIZED");
            res.getWriter().write("");
            return;
        }

        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        res.setHeader("Authentication", "UNAUTHORIZED");
        res.sendRedirect(ctx +  "/auth/sign-in");
    }

    private void handlePublicProfile(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String[] parts = req.getPathInfo().split("/");

        if (parts.length < 3 || !parts[2].matches("[a-z0-9_-]+")) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String nameId = parts[2];
        req.setAttribute("nameId", nameId);
        req.getRequestDispatcher("/WEB-INF/views/clients/public-profile.jsp").forward(req, res);
    }

    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)  {
        // Maneja las solicitudes POST si es necesario
        String pathInfo = req.getPathInfo();
        if (pathInfo == null ||  pathInfo.startsWith("/")) {

        }

    }*/
}