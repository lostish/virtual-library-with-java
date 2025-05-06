<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Tu cuenta {}- Virtual Library</title>
    <link
      rel="preload"
      href="http://localhost:8080/virtual-library/globals.css"
      as="style"
    />
    <link
      rel="preload"
      href="http://localhost:8080/virtual-library/styles/account.css"
      as="style"
    />
    <link
      rel="stylesheet"
      href="http://localhost:8080/virtual-library/globals.css"
    />
    <link
      rel="stylesheet"
      href="http://localhost:8080/virtual-library/styles/account.css"
    />
  </head>
  <body>
    <div>
      <header></header>
      <main class="account-main container">
        <!-- Profile Presentation and edit buttons -->
        <div class="account-user-data">
          <div class="account-avatar-container">
            <div
              class="account-avatar-wrapper"
              data-account-avatar-state="default"
            ></div>
            <button class="button button-primary account-avatar-edit-btn">
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
              >
                <path
                  d="M12 3H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"
                />
                <path
                  d="M18.375 2.625a1 1 0 0 1 3 3l-9.013 9.014a2 2 0 0 1-.853.505l-2.873.84a.5.5 0 0 1-.62-.62l.84-2.873a2 2 0 0 1 .506-.852z"
                />
              </svg>
            </button>
          </div>
          <div class="account-info-container">
            <h1>imlostish</h1>
            <div class="account-profile-data">
              <!-- Account email and created_at info -->
              <div class="profile-data-item">
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
                >
                  <rect width="20" height="16" x="2" y="4" rx="2" />
                  <path d="m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7" />
                </svg>
                <span>example@gmail.com</span>
              </div>
              <div class="profile-data-item">
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
                >
                  <path d="M8 2v4" />
                  <path d="M16 2v4" />
                  <rect width="18" height="18" x="3" y="4" rx="2" />
                  <path d="M3 10h18" />
                </svg>
                <span>Miembro desde 18 de junio del 2024</span>
              </div>
            </div>

            <div class="account-profile-badges">
              <!-- Accout badges data -->
              <div class="badge badge-primary">Plan Premium</div>
              <div class="badge badge-outline">Fantasia</div>
              <div class="badge badge-outline">Ciencia Ficciòn</div>
              <div class="badge badge-outline">Misterio</div>
            </div>

            <div class="account-edit-profile">
              <!-- Account private triggers -->
              <button class="button button-primary" data-fw="bold">
                Editar perfil
              </button>
              <button class="button button-dark" data-fw="bold">
                Cambiar plan
              </button>
            </div>
          </div>
        </div>

        <!-- PRIVATE! Profile edit options -->

        <section style="display: grid; gap: 1.15rem">
          <div class="card">
            <header class="card-header">
              <h3 class="card-title">Informaciòn Personal</h3>
              <p class="card-description">
                Gestiona tu información personal y preferencias
              </p>
            </header>
            <main class="card-content card-content-grid">
              <div class="card-field">
                <h4 class="card-field-name">Nombre completo</h4>
                <div class="card-field-data">
                  <p class="card-field-content">imlostish</p>
                  <button class="button button-ghost button-compact">
                    Editar
                  </button>
                </div>
                <div class="card-field-separator" aria-hidden="true"></div>
              </div>
              <div class="card-field">
                <h4 class="card-field-name">Correo electrónico</h4>
                <div class="card-field-data">
                  <p class="card-field-content">example@gmail.com</p>
                  <button class="button button-ghost button-compact">
                    Editar
                  </button>
                </div>
                <div class="card-field-separator" aria-hidden="true"></div>
              </div>
              <div class="card-field">
                <h4 class="card-field-name">Contraseña</h4>
                <div class="card-field-data">
                  <p class="card-field-content">••••••••••</p>
                  <button class="button button-ghost button-compact">
                    Editar
                  </button>
                </div>
                <div class="card-field-separator" aria-hidden="true"></div>
              </div>
            </main>
          </div>
          <div class="card">
            <header class="card-header">
              <h3 class="card-title">Preferencias de Lectura</h3>
              <p class="card-description">
                Personaliza tu experiencia de lectura
              </p>
            </header>
            <main class="card-content card-content-grid">
              <div class="card-field">
                <h4 class="card-field-name">Géneros favoritos</h4>
                <div class="card-field-data">
                  <div class="card-field-list">
                    <div class="badge badge-outline">Fantasía</div>
                    <div class="badge badge-outline">Ciencia Ficción</div>
                    <div class="badge badge-outline">Fantasía Ciencia</div>
                    <button class="badge badged-dashed">+ Añadir</button>
                  </div>
                </div>
                <div class="card-field-separator" aria-hidden="true"></div>
              </div>
              <div class="card-field">
                <h4 class="card-field-name">Notificaciones</h4>
                <form
                  style="display: flex; flex-flow: column nowrap; gap: 0.4rem"
                  action=""
                  method="post"
                >
                  <div class="card-field-toogle-sx">
                    <p>Nuevos lanzamientos</p>
                    <input type="checkbox" />
                  </div>
                  <div class="card-field-toogle-sx">
                    <p>Recomendaciones semanales</p>
                    <input type="checkbox" />
                  </div>
                  <div class="card-field-toogle-sx">
                    <p>Ofertas y promociones</p>
                    <input type="checkbox" />
                  </div>
                  <button
                    class="button button-primary"
                    style="margin: 0.45rem 0 0"
                  >
                    Guardar preferencias
                  </button>
                </form>
              </div>
            </main>
          </div>
        </section>
      </main>
    </div>
  </body>
</html>
