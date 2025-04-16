<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ingresa a tu cuenta - Virtual Library</title>
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
              <h1>Iniciar Sesión</h1>
              <p>
                Accede a tu biblioteca digital y continúa tu aventura literaria
              </p>
            </div>
          </div>

          <form class="form-body">
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
                <a
                  href="http://localhost:8080/virtual-library/auth/reset"
                  hreflang="es"
                  target="_self"
                  rel="noreferrer noopener"
                >
                  ¿Olvidaste tu contraseña?
                </a>
              </div>
              <input
                type="password"
                id="password"
                placeholder="••••••••"
                required
              />
            </div>

            <button type="submit" class="button button-primary">
              Iniciar Sesión
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
