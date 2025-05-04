package sh.losti.app.servlets;

import sh.losti.app.facade.AuthFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/reset")
public class ResetServlet extends HttpServlet {
    private static final AuthFacade authFacade = AuthFacade.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        res.setStatus(HttpServletResponse.SC_OK);
        req.getRequestDispatcher("/WEB-INF/views/auth/reset.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws  IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        authFacade.resetPassword(email, password);

    }
}
