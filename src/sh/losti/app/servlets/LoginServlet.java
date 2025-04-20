package sh.losti.app.servlets;

import sh.losti.app.models.Session;
import sh.losti.app.models.SessionData;
import sh.losti.app.services.AuthServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/sign-in")
public class LoginServlet extends HttpServlet {
    private final AuthServices auth = AuthServices.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        res.setStatus(HttpServletResponse.SC_OK);
        req.getRequestDispatcher("/WEB-INF/views/auth/sign-in.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        res.setContentType("application/json");

        if (!auth.isValidEmail(email) || !auth.isValidPassword(password)) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            res.getWriter().write("{\"error\": \"Email o contraseña inválidos\"}");
            return;
        }

        if (auth.login(email, password)) {
            Session session = auth.getSession();
            SessionData sessionData = auth.getSessionData();

            Cookie sessionCookie = new Cookie("session", session.toString());
            sessionCookie.setMaxAge(3 * 24 * 60 * 60);
            sessionCookie.setPath("/");

            Cookie sessionDataCookie = new Cookie("session-data", sessionData.toString());
            sessionDataCookie.setMaxAge(3 * 24 * 60 * 60);
            sessionDataCookie.setPath("/");

            res.addCookie(sessionCookie);
            res.addCookie(sessionDataCookie);
            res.sendRedirect(req.getContextPath() + "/account");
        } else {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("{\"error\": \"Credenciales inválidas\"}");
        }

    }
}
