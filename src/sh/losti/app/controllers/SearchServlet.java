import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search") // Esto mapea la URL "/search" al servlet
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenemos el valor del campo de búsqueda desde el formulario
        String searchTerm = request.getParameter("searchText");

        // Aquí se puede implementar la lógica de búsqueda, por ejemplo, consultar una
        // base de datos.
        // Por simplicidad, vamos a simular que devolvemos una respuesta con el término
        // buscado.

        // Configuramos el tipo de contenido de la respuesta.
        response.setContentType("text/html;charset=UTF-8");

        // Escribimos la respuesta HTML
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultados de Búsqueda</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultados de la búsqueda</h1>");
            out.println("<p>Has buscado: <strong>" + searchTerm + "</strong></p>");

            // Aquí se podría incluir lógica para mostrar una lista de resultados obtenidos
            // de una base de datos.

            out.println("<a href='index.html'>Volver al inicio</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}