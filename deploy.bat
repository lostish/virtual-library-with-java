@echo off
REM filepath: deploy.bat

REM Vars
set "TOMCAT_HOME=C:\path\to\apache-tomcat-9.0.1"
set "TOMCAT_BIN=%TOMCAT_HOME%\bin"
set "APP_NAME=virtual-library"
set "DEPLOY_DIR=%TOMCAT_HOME%\webapps\%APP_NAME%"
set "SETENV_BAT=%TOMCAT_BIN%\setenv.bat"

set EXPECTED_VARS=DB_URL DB_USER DB_PASSWORD

REM Cargar variables desde .env si existe
if exist .env (
    for /f "tokens=1,2 delims==" %%a in (.env) do (
        set "%%a=%%b"
    )
)

REM Función para actualizar setenv.bat
:UPDATE_ENV_FILE
if not exist "%SETENV_BAT%" (
    echo Creando archivo: %SETENV_BAT%
    echo @echo off > "%SETENV_BAT%"
)

for %%v in (%EXPECTED_VARS%) do (
    set "new_value=!%%v!"
    for /f "tokens=1,2 delims==" %%a in ('findstr /B "set %%v=" "%SETENV_BAT%"') do set "current_value=%%b"

    if not "!current_value!"=="!new_value!" (
        echo Actualizando %%v en %SETENV_BAT%
        echo set %%v=!new_value! >> "%SETENV_BAT%"
    )
)

REM 📌 Despliegue de la aplicación
echo Limpiando despliegue anterior...
if exist "%DEPLOY_DIR%" rmdir /s /q "%DEPLOY_DIR%"
mkdir "%DEPLOY_DIR%"

REM Copiar archivos
xcopy /E /I WebContent "%DEPLOY_DIR%"
xcopy /E /I bin "%DEPLOY_DIR%\WEB-INF\classes"

echo ✅ Despliegue completado en %DEPLOY_DIR%
