# Variables
$TOMCAT_HOME = "C:\Users\lost\Documents\apache-tomcat-9.0.1"
$TOMCAT_BIN = "$TOMCAT_HOME\bin"
$APP_NAME = "virtual-library"
$DEPLOY_DIR = "$TOMCAT_HOME\webapps\$APP_NAME"
$RESOURCES_SOURCE_DIR = "src\sh\losti\webapp\WEB-INF\resources\books"
$BOOK_RESOURCES_DEPLOY_DIR = "$DEPLOY_DIR\WEB-INF\resources\books"

Write-Host "🔍 Buscando procesos Tomcat..."
$tomcatProcesses = Get-CimInstance Win32_Process | Where-Object { $_.CommandLine -like "*org.apache.catalina.startup.Bootstrap*" }

if ($tomcatProcesses.Count -eq 0) {
    Write-Host "✔️  No se encontraron procesos Tomcat."
} else {
    foreach ($proc in $tomcatProcesses) {
        Write-Host "🗡️  Terminando PID $($proc.ProcessId)"
        Stop-Process -Id $proc.ProcessId -Force
    }
    Write-Host "✅ Procesos de Tomcat detenidos."
}

Write-Host "🔍 Compilando proyecto..."
javac -Xlint:none -d bin -cp "lib/*" (Get-ChildItem -Recurse src/sh/losti/app -Filter *.java | ForEach-Object { $_.FullName })
Write-Host "✅ Compilación terminada."

# Cargar .env

$setenvPath = Join-Path $TOMCAT_BIN "setenv.bat"
$scriptPath = Join-Path $PSScriptRoot "scripts/mount-env.ps1"
& $scriptPath -SetenvPath $setenvPath

# Despliegue
Write-Host "Limpiando despliegue anterior..."
Remove-Item -Recurse -Force -ErrorAction Ignore $DEPLOY_DIR
New-Item -ItemType Directory -Force -Path "$DEPLOY_DIR\WEB-INF\classes\sh\losti"
New-Item -ItemType Directory -Force -Path "$DEPLOY_DIR\WEB-INF\lib"
New-Item -ItemType Directory -Force -Path "$DEPLOY_DIR\WEB-INF\resources\books"

Copy-Item -Recurse -Force src/sh/losti/webapp/* $DEPLOY_DIR
Copy-Item -Recurse -Force bin/sh/losti/app $DEPLOY_DIR\WEB-INF\classes\sh\losti\
Copy-Item -Recurse -Force lib\*.jar $DEPLOY_DIR\WEB-INF\lib\
Copy-Item -Recurse -Force "$RESOURCES_SOURCE_DIR\*" "$BOOK_RESOURCES_DEPLOY_DIR\"

Write-Host "✅ Despliegue completado en $DEPLOY_DIR"
