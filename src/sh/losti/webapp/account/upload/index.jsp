<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sube tu libro losti</title>
    <link
      rel="preload"
      href="http://localhost:8080/virtual-library/globals.css"
      as="style"
    />
    <link
      rel="stylesheet"
      href="http://localhost:8080/virtual-library/globals.css"
    />
  </head>
  <body>
      <form class="form-body" method="post" action="<%=request.getContextPath()%>/upload-book" enctype="multipart/form-data">
          <div class="form-group">
            <input type="file" name="book_file" accept=".pdf,.doc,.docx,.md" required />
            <button type="submit">Subir</button>
          </div>
      </form>

      <%
          String message = (String) request.getAttribute("message");
          if (message != null) {
      %>
          <p><strong><%= message %></strong></p>
      <%
          }
          String uploadedFile = (String) request.getAttribute("uploaded_file");
          if (uploadedFile != null) {
      %>
          <p>Archivo subido: <%= uploadedFile %></p>
      <%
          }
      %>

  </body>
</html>
