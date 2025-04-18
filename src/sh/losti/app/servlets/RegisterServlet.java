package sh.losti.app.servlets;

import sh.losti.app.services.AuthServices;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/sign-up")
public class RegisterServlet extends HttpServlet {
    private final AuthServices auth = AuthServices.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        res.setContentType("application/json");

        if (!auth.isValidEmail(email) || !auth.isValidPassword(password)) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            res.getWriter().write("{\"error\": \"Email o contraseña inválidos\"}");
            return;
        }

        boolean success = auth.signUp(name, email, password);

        if (!success) {
            res.setStatus(HttpServletResponse.SC_CONFLICT);
            res.getWriter().write("{\"error\": \"El usuario ya existe\"}");
        }

        res.setStatus(HttpServletResponse.SC_OK);
        res.getWriter().write("{\"message\": \"Registro exitoso\"}");
    }
}
