package sh.losti.app.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/library/about/*")
public class LibraryServlet extends HttpServlet {
    private static final String RESOURCE_BASE_PATH = "/WEB-INF/classes/resources/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String resourcePath = request.getPathInfo(); // Obtiene la ruta después de /resources/
        if (resourcePath == null || resourcePath.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Recurso no especificado");
            return;
        }

        File resourceFile = new File(getServletContext().getRealPath(RESOURCE_BASE_PATH + resourcePath));
        if (!resourceFile.exists() || resourceFile.isDirectory()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Recurso no encontrado");
            return;
        }

        // Configurar el tipo de contenido
        String mimeType = getServletContext().getMimeType(resourceFile.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLengthLong(resourceFile.length());

        // Enviar el archivo al cliente
        try (FileInputStream fis = new FileInputStream(resourceFile);
             OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        }
    }
}