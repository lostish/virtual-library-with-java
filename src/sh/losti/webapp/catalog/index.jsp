<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Catalogo - Virtual Library</title>
    <link
      rel="preload"
      href="http://localhost:8080/virtual-library/globals.css"
      as="style"
    />
    <link
      rel="preload"
      href="http://localhost:8080/virtual-library/styles/header.css"
      as="style"
    />
    <link
      rel="preload"
      href="http://localhost:8080/virtual-library/styles/hero-section.css"
      as="style"
    />
    <link
      rel="stylesheet"
      href="http://localhost:8080/virtual-library/globals.css"
    />
    <link
      rel="stylesheet"
      href="http://localhost:8080/virtual-library/styles/header.css"
    />
    <link
      rel="stylesheet"
      href="http://localhost:8080/virtual-library/styles/hero-section.css"
    />
    <link
      rel="stylesheet"
      href="http://localhost:8080/virtual-library/styles/search-section.css"
    />
  </head>
  <body>
    <header class="header">
      <div class="header-wrapper">
        <a
          class="logo"
          href="http://localhost:8080/virtual-library/"
          hreflang="es"
          target="_self"
          rel="noreferrer noopener"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            class="logo-icon"
          >
            <path d="M12 7v14" />
            <path
              d="M3 18a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h5a4 4 0 0 1 4 4 4 4 0 0 1 4-4h5a1 1 0 0 1 1 1v13a1 1 0 0 1-1 1h-6a3 3 0 0 0-3 3 3 3 0 0 0-3-3z"
            />
          </svg>
          <span class="logo-text">Virtual Library</span>
        </a>
        <nav class="nav">
          <a href="#" hreflang="es" target="_self" rel="noreferrer noopener">
            Inicio
          </a>
          <a
            href="http://localhost:8080/virtual-library/catalog/"
            hreflang="es"
            target="_self"
            rel="noreferrer noopener"
          >
            Catálogo
          </a>
          <a href="#" hreflang="es" target="_self" rel="noreferrer noopener">
            Precios
          </a>
          <a href="#" hreflang="es" target="_self" rel="noreferrer noopener">
            Blog
          </a>
        </nav>
        <div class="auth-links">
          <a
            class="login"
            href="http://localhost:8080/virtual-library/auth/sign-in"
            hreflang="es"
            target="_self"
            rel="noreferrer noopener"
          >
            Iniciar Sesión
          </a>
          <a
            class="button button-primary"
            href="http://localhost:8080/virtual-library/auth/sign-up"
            hreflang="es"
            target="_self"
            rel="noreferrer noopener"
            >Registrarse</a
          >
        </div>
      </div>
    </header>

    <!-- Hero section -->
    <section class="hero">
      <div class="hero-container">
        <div class="hero-grid">
          <div class="hero-content">
            <div class="hero-tag">Tu biblioteca digital</div>
            <h1 class="hero-title">
              Explora el catalogo de los mejores libros con
              <span>conocimiento</span> en tus manos.
            </h1>
            <p class="hero-description">
              Miles de libros digitales accesibles desde cualquier dispositivo.
              Lee, aprende y explora sin límites.
            </p>
          </div>
          <div class="hero-card-wrapper">
            <div class="hero-card">
              <div class="hero-card-content">
                <div class="hero-card-header">
                  <div class="circle circle-red"></div>
                  <div class="circle circle-yellow"></div>
                  <div class="circle circle-green"></div>
                  <div
                    style="
                      margin-left: 0.25rem;
                      font-size: 0.75rem;
                      color: oklch(55.2% 0.016 285.938);
                    "
                  >
                    LibroVerse Reader
                  </div>
                </div>
                <div class="hero-card-placeholder">
                  <div class="card-item-w-3-4"></div>
                  <div class="card-item-w-full"></div>
                  <div class="card-item-w-5-6"></div>
                  <div class="card-item-w-2-3"></div>
                </div>
                <div class="hero-card-footer">
                  <div class="page-info">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="16"
                      height="16"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      style="width: 16px; height: 16px"
                      class="logo-icon"
                    >
                      <path
                        d="M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20"
                      />
                    </svg>
                    <span>Página 42 de 320</span>
                  </div>
                  <div class="starts">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="star"
                    >
                      <path
                        d="M11.525 2.295a.53.53 0 0 1 .95 0l2.31 4.679a2.123 2.123 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904l-3.736 3.638a2.123 2.123 0 0 0-.611 1.878l.882 5.14a.53.53 0 0 1-.771.56l-4.618-2.428a2.122 2.122 0 0 0-1.973 0L6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.122 2.122 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.122 2.122 0 0 0 1.597-1.16z"
                      />
                    </svg>
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="star"
                    >
                      <path
                        d="M11.525 2.295a.53.53 0 0 1 .95 0l2.31 4.679a2.123 2.123 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904l-3.736 3.638a2.123 2.123 0 0 0-.611 1.878l.882 5.14a.53.53 0 0 1-.771.56l-4.618-2.428a2.122 2.122 0 0 0-1.973 0L6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.122 2.122 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.122 2.122 0 0 0 1.597-1.16z"
                      />
                    </svg>
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="star"
                    >
                      <path
                        d="M11.525 2.295a.53.53 0 0 1 .95 0l2.31 4.679a2.123 2.123 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904l-3.736 3.638a2.123 2.123 0 0 0-.611 1.878l.882 5.14a.53.53 0 0 1-.771.56l-4.618-2.428a2.122 2.122 0 0 0-1.973 0L6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.122 2.122 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.122 2.122 0 0 0 1.597-1.16z"
                      />
                    </svg>
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="star"
                    >
                      <path
                        d="M11.525 2.295a.53.53 0 0 1 .95 0l2.31 4.679a2.123 2.123 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904l-3.736 3.638a2.123 2.123 0 0 0-.611 1.878l.882 5.14a.53.53 0 0 1-.771.56l-4.618-2.428a2.122 2.122 0 0 0-1.973 0L6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.122 2.122 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.122 2.122 0 0 0 1.597-1.16z"
                      />
                    </svg>
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="star empty"
                    >
                      <path
                        d="M11.525 2.295a.53.53 0 0 1 .95 0l2.31 4.679a2.123 2.123 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904l-3.736 3.638a2.123 2.123 0 0 0-.611 1.878l.882 5.14a.53.53 0 0 1-.771.56l-4.618-2.428a2.122 2.122 0 0 0-1.973 0L6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.122 2.122 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.122 2.122 0 0 0 1.597-1.16z"
                      />
                    </svg>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <div style="border-bottom: 1px solid hsl(240, 4%, 16%)">
      <section class="search-section">
        <div class="search-container">
          <div class="search-header">
            <h2 class="search-title">
              Encuentra tu próxima <span>aventura</span>
            </h2>
            <p class="search-description">
              Explora nuestra extensa colección de libros digitales y encuentra
              tu próxima lectura favorita.
            </p>
          </div>

          <div class="search-box search-box-high">
            <div class="search-wrapper">
              <form
                action="search"
                style="display: flex; flex-flow: row nowrap; gap: 0.875rem"
              >
                <input
                  type="text"
                  class="search-input"
                  placeholder="Busca por título, autor o género..."
                />
                <button class="button button-primary">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    fill="none"
                    stroke="currentColor"
                    stroke-width="2"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  >
                    <circle cx="11" cy="11" r="8" />
                    <path d="m21 21-4.3-4.3" />
                  </svg>
                  Buscar
                </button>
              </form>
              <div class="search-tags">
                <span class="search-tag">Ficción</span>
                <span class="search-tag">No ficción</span>
                <span class="search-tag">Fantasía</span>
                <span class="search-tag">Ciencia</span>
                <span class="search-tag">Historia</span>
                <span class="search-tag">Biografías</span>
                <span class="search-tag">Autoayuda</span>
                <span class="search-tag">Negocios</span>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </body>
</html>
