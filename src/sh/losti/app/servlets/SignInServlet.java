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
public class SignInServlet extends HttpServlet {
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
        String ctx = req.getContextPath();

        System.out.println("[DEBUG] Llamando a los valores de LOGIN SERVLET [POST]");
        System.out.println("[DEBUG] email: " + email);
        System.out.println("[DEBUG] password: " + password);

        res.setContentType("application/json");

        if (!auth.isValidEmail(email) || !auth.isValidPassword(password)) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            res.getWriter().write("{\"error\": \"Email o contraseña inválidos\"}");
            System.out.println("[DEBUG] LOGIN SERVLET [POST] - No pasaron las expresiones regulares");
            return;
        }

        if (auth.login(email, password)) {
            Session session = auth.getSession();
            SessionData sessionData = auth.getSessionData();

            System.out.println("[DEBUG] LOGIN SERVLET [POST] - session: " + session.toString());
            System.out.println("[DEBUG] LOGIN SERVLET [POST] - session data: " + sessionData.toString());

            Cookie sessionCookie = new Cookie("session", session.toString());
            sessionCookie.setMaxAge(3 * 24 * 60 * 60);
            sessionCookie.setPath("/");

            Cookie sessionDataCookie = new Cookie("session-data", sessionData.toString());
            sessionDataCookie.setMaxAge(3 * 24 * 60 * 60);
            sessionDataCookie.setPath("/");

            res.addCookie(sessionCookie);
            res.addCookie(sessionDataCookie);
            System.out.println("[DEBUG] LOGIN SERVLET [POST] - Se redirecciono a '/account'");
            res.sendRedirect(ctx + "/account");
            return;
        }

        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        res.getWriter().write("{\"error\": \"Credenciales inválidas\"}");
        res.sendRedirect(ctx + "/unauthorized");
        System.out.println("[DEBUG] LOGIN SERVLET [POST] - Inicio de secciòn no autorizado");
    }
}