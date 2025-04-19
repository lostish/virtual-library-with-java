@echo off
setlocal

:: Vars
set "TOMCAT_HOME=C:\Users\lost\Documents\apache-tomcat-9.0.1"
set "TOMCAT_BIN=%TOMCAT_HOME%\bin"
set "APP_NAME=virtual-library"
set "DEPLOY_DIR=%TOMCAT_HOME%\webapps\%APP_NAME%"
set "RESOURCES_SOURCE_DIR=src\sh\losti\webapp\WEB-INF\resources\books"
set "BOOK_RESOURCES_DEPLOY_DIR=%DEPLOY_DIR%\WEB-INF\resources\books"

echo 🔍 Terminando procesos Tomcat...
for /f "tokens=2" %%a in ('wmic process where "CommandLine like '%%org.apache.catalina.startup.Bootstrap%%'" get ProcessId /format:value ^| find "="') do (
    echo 🗡️  Terminando PID %%a
    taskkill /PID %%a /F >nul 2>&1
)

echo 🔍 Compilando proyecto...
if not exist bin mkdir bin
javac -Xlint:none -d bin -cp "lib/*" @findstr /S /I /R ".*\.java" src\sh\losti\app\*.java
echo ✅ Compilación terminada!

set SETENV_BAT=%TOMCAT_BIN%\setenv.bat

call scripts\mount-env.bat "%SETENV_BAT%"


:: Despliegue
echo Limpiando despliegue anterior...
rd /s /q "%DEPLOY_DIR%" 2>nul
mkdir "%DEPLOY_DIR%\WEB-INF\classes\sh\losti"
mkdir "%DEPLOY_DIR%\WEB-INF\lib"
mkdir "%DEPLOY_DIR%\WEB-INF\resources\books"

xcopy /s /e /y src\sh\losti\webapp\* "%DEPLOY_DIR%"
xcopy /s /e /y bin\sh\losti\app "%DEPLOY_DIR%\WEB-INF\classes\sh\losti\"
xcopy /s /e /y lib\*.jar "%DEPLOY_DIR%\WEB-INF\lib"
xcopy /s /e /y "%RESOURCES_SOURCE_DIR%\*" "%BOOK_RESOURCES_DEPLOY_DIR%\"

echo ✅ Despliegue completado en %DEPLOY_DIR%
endlocal
