package sh.losti.app.servlets;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.*;

@MultipartConfig
public class UploadBookServlet extends HttpServlet {

    private static final String BOOKS_DIR = "/WEB-INF/resources/books/";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("book_file");

        if (filePart == null || filePart.getSize() == 0) {
            request.setAttribute("message", "Archivo no válido.");
            request.getRequestDispatcher("/account/upload/index.jsp").forward(request, response);
            return;
        }

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

        if (!extension.matches("pdf|docx?|md")) {
            request.setAttribute("message", "Tipo de archivo no permitido.");
            request.getRequestDispatcher("/account/upload/index.jsp").forward(request, response);
            return;
        }

        String realPath = getServletContext().getRealPath(BOOKS_DIR);
        File uploadDir = new File(realPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        File file = new File(uploadDir, fileName);
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        request.setAttribute("message", "Archivo subido correctamente.");
        request.setAttribute("uploaded_file", fileName);
        request.getRequestDispatcher("/account/upload/index.jsp").forward(request, response);
    }
}
