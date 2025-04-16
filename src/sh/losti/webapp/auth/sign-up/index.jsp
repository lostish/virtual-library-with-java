<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Crea tu cuenta - Virtual Library</title>
    <link
      rel="stylesheet"
      href="http://localhost:8080/virtual-library/globals.css"
    />
    <link
      rel="stylesheet"
      href="http://localhost:8080/virtual-library/styles/forms.css"
    />
  </head>
  <body>
    <div class="form-page">
      <div style="position: relative">
        <div class="glow-effect"></div>
        <div class="form-card">
          <div class="form-header">
            <div>
              <svg
                class="form-header-icon"
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M12 6v6h6"
                />
              </svg>
              <span class="form-header-webname">LibroVerse</span>
            </div>
            <div class="form-header-metadata">
              <h1>Crear Cuenta</h1>
              <p>
                Únete a nuestra comunidad de lectores y descubre miles de libros
              </p>
            </div>
          </div>

          <form class="form-body">
            <div class="form-group">
              <label for="name">Nombre completo</label>
              <input
                type="text"
                id="name"
                name="name"
                placeholder="Tu nombre"
                required
              />
            </div>

            <div class="form-group">
              <label for="email">Correo electrónico</label>
              <input
                type="email"
                id="email"
                name="email"
                placeholder="tu@email.com"
                required
              />
            </div>

            <div class="form-group">
              <label for="password">Contraseña</label>
              <input
                type="password"
                id="password"
                name="password"
                placeholder="••••••••"
                required
              />
              <p class="help-text">
                La contraseña debe tener al menos 8 caracteres, incluyendo una
                letra mayúscula y un número
              </p>
            </div>

            <button type="submit" class="button button-primary">
              Crear Cuenta
            </button>
          </form>

          <div class="form-refer-to">
            <p>
              ¿Ya tienes una cuenta?
              <a
                href="http://localhost:8080/virtual-library/auth/sign-in/"
                hreflang="es"
                target="_self"
                rel="noreferrer noopener"
              >
                Iniciar sesión
              </a>
            </p>
          </div>

          <div class="form-legal">
            <p>
              Al iniciar sesión, aceptas nuestros
              <a
                href="http://localhost:8080/virtual-library/terms"
                hreflang="es"
                target="_self"
                rel="noreferrer noopener"
              >
                Términos de Servicio
              </a>
              y
              <a
                href="http://localhost:8080/virtual-library/privacy"
                hreflang="es"
                target="_self"
                rel="noreferrer noopener"
              >
                Política de Privacidad
              </a>
            </p>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
