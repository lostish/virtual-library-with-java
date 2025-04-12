<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./globals.css" />
    <link rel="stylesheet" href="./header.css" />
    <link rel="stylesheet" href="./hero-section.css" />
    <link rel="stylesheet" href="./search-section.css" />
    <link rel="stylesheet" href="./features-section.css" />
    <link rel="stylesheet" href="./pricing.css" />
    <link rel="stylesheet" href="./cta.css" />
    <title>
      Descubre un mundo de conocimiento en tus manos - Virtual Library
    </title>
  </head>
  <body>
    <header class="header">
      <div class="header-wrapper">
        <div class="logo">
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
        </div>
        <nav class="nav">
          <a href="#" hreflang="es" target="_self" rel="noreferrer noopener">
            Inicio
          </a>
          <a href="#" hreflang="es" target="_self" rel="noreferrer noopener">
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
          <a href="#" class="login"> Iniciar Sesión </a>
          <button class="button button-primary">Registrarse</button>
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
              Descubre un mundo de
              <span>conocimiento</span> en tus manos
            </h1>
            <p class="hero-description">
              Miles de libros digitales accesibles desde cualquier dispositivo.
              Lee, aprende y explora sin límites.
            </p>
            <div class="hero-buttons">
              <a class="button button-primary">Comenzar ahora</a>
              <a class="button button-dark">
                Ver catálogo
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
                  style="height: 16px; height: 16px"
                >
                  <path d="m9 18 6-6-6-6" />
                </svg>
              </a>
            </div>
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
      <!-- Search Section -->

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

          <div class="search-box">
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
                <button class="search-button">
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

      <!-- Features section -->
      <section class="features-section">
        <div class="features-container">
          <h2 class="features-title">
            Una experiencia de lectura <span>revolucionaria</span>
          </h2>
          <p class="features-description">
            Nuestra plataforma está diseñada para ofrecer la mejor experiencia
            de lectura digital, con características que transformarán tu forma
            de leer.
          </p>
        </div>

        <div class="features-grid">
          <div class="feature-card">
            <div class="feature-icon-container">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                width="40"
                height="40"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M4 19V5a2 2 0 012-2h10a2 2 0 012 2v14M8 7h6M8 11h6M8 15h2M16 5v14"
                />
              </svg>
            </div>
            <h3 class="feature-title">Biblioteca Ilimitada</h3>
            <p class="feature-description">
              Accede a miles de títulos de todos los géneros, desde clásicos
              hasta los últimos lanzamientos.
            </p>
          </div>

          <div class="feature-card">
            <div class="feature-icon-container">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="40"
                height="40"
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
            </div>
            <h3 class="feature-title">Búsqueda Inteligente</h3>
            <p class="feature-description">
              Encuentra exactamente lo que buscas con nuestro potente motor de
              búsqueda y recomendaciones personalizadas.
            </p>
          </div>

          <div class="feature-card">
            <div class="feature-icon-container">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="40"
                height="40"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              >
                <path d="M18 21a8 8 0 0 0-16 0" />
                <circle cx="10" cy="8" r="5" />
                <path d="M22 20c0-3.37-2-6.5-4-8a5 5 0 0 0-.45-8.3" />
              </svg>
            </div>
            <h3 class="feature-title">Comunidad Lectora</h3>
            <p class="feature-description">
              Comparte opiniones, reseñas y descubre nuevos títulos recomendados
              por otros lectores.
            </p>
          </div>
        </div>
      </section>

      <!-- Pricing -->

      <section class="pricing-section">
        <div class="container">
          <div class="pricing-header">
            <h2>Planes <span class="highlight">simples</span> para todos</h2>
            <p>
              Elige el plan que mejor se adapte a tus necesidades de lectura.
            </p>
          </div>

          <div class="pricing-grid">
            <div class="pricing-card">
              <h3 class="plan-name">Básico</h3>
              <p class="plan-price">Gratis</p>
              <button class="plan-button">Elegir plan</button>
              <ul class="plan-features">
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Acceso a 100+ libros
                </li>
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Lectura en un dispositivo
                </li>
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Marcadores básicos
                </li>
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Soporte por email
                </li>
              </ul>
            </div>

            <div class="pricing-card popular">
              <div class="popular-label">Más popular</div>
              <h3 class="plan-name">Premium</h3>
              <p class="plan-price">9.99€/mes</p>
              <button class="plan-button popular-button">Elegir plan</button>
              <ul class="plan-features">
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Acceso a 10,000+ libros
                </li>
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Lectura en múltiples dispositivos
                </li>
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Notas y marcadores avanzados
                </li>
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Descarga para lectura offline
                </li>
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Soporte prioritario
                </li>
              </ul>
            </div>

            <div class="pricing-card">
              <h3 class="plan-name">Familiar</h3>
              <p class="plan-price">14.99€/mes</p>
              <button class="plan-button">Elegir plan</button>
              <ul class="plan-features">
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Todo lo de Premium
                </li>
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Hasta 5 perfiles
                </li>
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Control parental
                </li>
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Recomendaciones personalizadas
                </li>
                <li>
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
                    class="lucide lucide-chevron-right-icon lucide-chevron-right"
                  >
                    <path d="m9 18 6-6-6-6" />
                  </svg>
                  Soporte 24/7
                </li>
              </ul>
            </div>
          </div>
        </div>
      </section>

      <!-- Call to action section -->
      <section class="cta-section">
        <div class="container">
          <h2>
            Comienza tu viaje literario <span class="highlight">hoy mismo</span>
          </h2>
          <p>
            Únete a miles de lectores que ya disfrutan de la mejor experiencia
            de lectura digital. Tu próxima gran historia te espera.
          </p>
          <div class="cta-buttons">
            <button class="cta-primary">Registrarse gratis</button>
            <button class="cta-secondary">Ver planes premium</button>
          </div>
        </div>
      </section>
    </div>
  </body>
</html>
