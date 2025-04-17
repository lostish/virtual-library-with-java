package sh.losti.app.controllers;

import sh.losti.app.services.AuthServices;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private final AuthServices auth = AuthServices.getInstance();

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

    }
}
