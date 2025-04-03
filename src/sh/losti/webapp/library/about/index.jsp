<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>About <%= request.getAttribute("slug") %> - Virtual Library</title>
  </head>
  <body>
    <h1>Sobre el libro</h1>
    <p>Título del libro: <b><%= request.getAttribute("bookTitle") %></b></p>
  </body>
</html>
