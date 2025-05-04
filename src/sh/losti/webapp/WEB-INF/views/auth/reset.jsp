<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cambiar contraseña - Virtual Library</title>
    <link
      rel="preload"
      href="http://localhost:8080/virtual-library/globals.css"
      as="style"
    />
    <link
      rel="preload"
      href="http://localhost:8080/virtual-library/styles/forms.css"
      as="style"
    />
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
              <h1>Cambiar contraseña</h1>
              <p>
                Vuelve a tener acceso a tu cuenta facilmente cambiando la
                contraseña por una nueva!
              </p>
            </div>
          </div>
          <form class="form-body" action="/auth/reset" method="POST">
            <div class="form-group">
              <label for="email">Correo electrónico</label>
              <input
                type="email"
                id="email"
                placeholder="tu@email.com"
                required
              />
            </div>

            <div class="form-group">
              <div class="form-label-row">
                <label for="password">Contraseña</label>
              </div>
              <input
                type="password"
                id="password"
                placeholder="••••••••"
                required
              />
            </div>

            <div class="form-group">
              <div class="form-label-row">
                <label for="confirm-password">Confirmar Contraseña</label>
              </div>
              <input
                type="password"
                id="confirm-password"
                placeholder="••••••••"
                required
              />
            </div>

            <button type="submit" class="button button-primary">
              Actualizar
            </button>
          </form>

          <div class="form-refer-to">
            <p>
              ¿No tienes una cuenta?
              <a
                href="http://localhost:8080/virtual-library/auth/sign-up/"
                hreflang="es"
                target="_self"
                rel="noreferrer noopener"
              >
                Crear cuenta
              </a>
            </p>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
