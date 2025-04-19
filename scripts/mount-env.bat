@echo off
setlocal enabledelayedexpansion

:: Default Tomcat setenv.bat path
set "DEFAULT_TOMCAT_HOME=C:\Users\lost\Documents\apache-tomcat-9.0.1"
set "DEFAULT_SETENV_BAT=%DEFAULT_TOMCAT_HOME%\bin\setenv.bat"
set "SETENV_BAT=%~1"
if "%SETENV_BAT%"=="" set "SETENV_BAT=%DEFAULT_SETENV_BAT%"

call :update_env_file "%SETENV_BAT%"
goto :eof

:update_env_file
:: Argument: %1 = setenv.bat path
set "file=%~1"

if not exist "%file%" (
    echo Creando archivo: %file%
    echo @echo off > "%file%"
)

:: Leer archivo .env
if exist .env (
    for /f "usebackq tokens=1,2 delims==" %%i in (`findstr /v "^#" .env`) do (
        if not "%%i"=="" (
            set "%%i=%%j"
        )
    )
)

:: Lista de variables esperadas
set "EXPECTED_VARS=DB_URL DB_USER DB_PASSWORD"

:: Agregar variables al archivo si no existen o están desactualizadas
for %%V in (%EXPECTED_VARS%) do (
    set "key=%%V"
    set "value=!%%V!"
    set "exists="
    for /f "tokens=* delims=" %%l in ('findstr /i "set %%V=" "%file%"') do (
        set "exists=1"
    )
    if not defined exists (
        echo set %%V=!value!>> "%file%"
    )
)

goto :eof
