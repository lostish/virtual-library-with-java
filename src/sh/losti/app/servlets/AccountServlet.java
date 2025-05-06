package sh.losti.app.servlets;

import sh.losti.app.constants.AuthConstants;
import sh.losti.app.enums.EBookDownloadType;
import sh.losti.app.enums.EBookPostType;
import sh.losti.app.enums.EBookState;
import sh.losti.app.models.Session;
import sh.losti.app.services.AuthServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
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
                    .filter(cookie -> AuthConstants.getAuthCookies()[0].equals(cookie.getName()))
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
            req.getRequestDispatcher("WEB-INF/views/clients/private-profile.jsp").forward(req, res);
            return;
        }


        if (pathInfo != null && pathInfo.equals("/settings") && isLoggedIn) {
            res.setStatus(HttpServletResponse.SC_OK);
            res.setHeader("Authentication", "AUTHORIZED");
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String pathInfo = req.getPathInfo();
        String ctx = req.getContextPath();
        String contentTye = req.getContentType();

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            Arrays.stream(cookies)
                    .filter(cookie -> AuthConstants.getAuthCookies()[0].equals(cookie.getName()))
                    .findFirst()
                    .ifPresent(cookie -> session = Session.fromJson(cookie.getValue()));
        }

        boolean isLoggedIn = session != null && auth.isValidSession(session);

        if (!isLoggedIn) res.sendRedirect(ctx + "/unauthorized");

        if ((pathInfo != null && pathInfo.equals("/upload")) && contentTye.equals("multipart/form-data")) {
            int userId = Integer.parseInt(req.getParameter("user-id"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            boolean published = Boolean.parseBoolean(req.getParameter("published"));
            EBookState state = EBookState.valueOf(req.getParameter("state"));
            EBookPostType postType = EBookPostType.valueOf(req.getParameter("post-type"));
            EBookDownloadType download = EBookDownloadType.valueOf(req.getParameter("download"));
            File file = new File(req.getParameter("file"));
        }

    }
}