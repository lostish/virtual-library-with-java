package sh.losti.app.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibraryServlet extends HttpServlet {
    private final Map<String, String> books = new HashMap<>();

    @Override
    public void init() {
        books.put("harry-potter", "Harry Potter y la Piedra Filosofal");
        books.put("lotr", "El Señor de los Anillos");
        books.put("default-book", "Libro Desconocido");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // Obtiene la parte dinámica de la URL
        String slug = (pathInfo != null && pathInfo.length() > 1) ? pathInfo.substring(1) : "default-book";

        String bookTitle = books.getOrDefault(slug, "Libro no encontrado");
        request.setAttribute("slug", slug);
        request.setAttribute("bookTitle", bookTitle);

        // Redirige a la página JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/library/about/index.jsp");
        dispatcher.forward(request, response);
    }
}