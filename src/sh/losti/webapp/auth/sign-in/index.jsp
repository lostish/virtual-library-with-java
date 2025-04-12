<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ingresa a tu cuenta - Virtual Library</title>
    <link rel="stylesheet" href="../../globals.css" />
    <link rel="stylesheet" href="./login.css" />
  </head>
  <body>
    <div class="login-page">
      <div class="login-container">
        <div class="glow-effect"></div>

        <div class="login-box">
          <div class="login-logo">
            <!-- Aquí debes insertar un SVG o un ícono BookOpen -->
            <span class="logo-icon">📖</span>
            <span class="logo-text">LibroVerse</span>
          </div>

          <div class="login-header">
            <h1>Iniciar Sesión</h1>
            <p>
              Accede a tu biblioteca digital y continúa tu aventura literaria
            </p>
          </div>

          <form class="login-form">
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
                <a href="/recuperar-password">¿Olvidaste tu contraseña?</a>
              </div>
              <input
                type="password"
                id="password"
                placeholder="••••••••"
                required
              />
            </div>

            <button type="submit" class="login-button">Iniciar Sesión</button>
          </form>

          <div class="signup-link">
            <p>
              ¿No tienes una cuenta?
              <a href="/registro">Crear cuenta</a>
            </p>
          </div>

          <div class="terms">
            <p>
              Al iniciar sesión, aceptas nuestros
              <a href="/terminos">Términos de Servicio</a>
              y
              <a href="/privacidad">Política de Privacidad</a>
            </p>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
