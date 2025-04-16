<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Tu cuenta {}- Virtual Library</title>
    <link rel="stylesheet" href="../../globals.css" />
    <link rel="stylesheet" href="./account.css" />
  </head>
  <body>
    <div>
      <header></header>
      <main class="account-main container">
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
            <div>
              <!-- Account email and created_at info -->
              <div>
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
              <div>
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

            <div>
              <!-- Accout badges data -->
            </div>

            <div>
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
      </main>
    </div>
  </body>
</html>
