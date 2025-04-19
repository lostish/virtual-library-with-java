@echo off
setlocal

set "TOMCAT_HOME=C:\Users\lost\Documents\apache-tomcat-9.0.1"
set "TOMCAT_BIN=%TOMCAT_HOME%\bin"

echo 🚀 Iniciando Apache Tomcat desde: %TOMCAT_BIN%
call "%TOMCAT_BIN%\startup.bat"

if %errorlevel%==0 (
    echo ✅ Tomcat iniciado correctamente.
) else (
    echo ❌ Hubo un error al iniciar Tomcat.
)

endlocal
