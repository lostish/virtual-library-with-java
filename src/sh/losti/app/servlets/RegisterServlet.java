package sh.losti.app.servlets;

import sh.losti.app.services.AuthServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/sign-up")
public class RegisterServlet extends HttpServlet {
    private final AuthServices auth = AuthServices.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        res.setStatus(HttpServletResponse.SC_OK);
        req.getRequestDispatcher("/WEB-INF/views/auth/sign-up.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        System.out.println("[DEBUG] Llamando a los valores de REGISTER SERVLET [POST]");
        System.out.println("[DEBUG] name: " + name);
        System.out.println("[DEBUG] email: " + email);
        System.out.println("[DEBUG] password: " + password);

        res.setContentType("application/json");

        if (!auth.isValidEmail(email) || !auth.isValidPassword(password)) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            res.getWriter().write("{\"error\": \"Email o contraseña inválidos\"}");
            System.out.println("[DEBUG] REGISTER SERVLET [POST] - No pasaron las expresiones regulares");
            return;
        }

        System.out.println("[DEBUG] REGISTER SERVLET [POST] - Pasaron las expresiones regulares");

        boolean success = auth.signUp(name, email, password);

        System.out.println("[DEBUG] REGISTER SERVLET [POST] - Se ejecuto el proceso de crear un usuario");

        if (!success) {
            res.setStatus(HttpServletResponse.SC_CONFLICT);
            res.getWriter().write("{\"error\": \"El usuario ya existe\"}");
            System.out.println("[DEBUG] REGISTER SERVLET [POST] - No se creo el usuario");
            return;
        }

        System.out.println("[DEBUG] REGISTER SERVLET [POST] - Se creo el usuario");
        res.sendRedirect(req.getContextPath() + "/auth/sign-in");
    }
}
