# filepath: start-server.ps1

$TOMCAT_HOME = "C:\Users\lost\Documents\apache-tomcat-9.0.1"
$TOMCAT_BIN = Join-Path $TOMCAT_HOME "bin"

Write-Host "🚀 Iniciando Apache Tomcat desde: $TOMCAT_BIN"

$startupScript = Join-Path $TOMCAT_BIN "startup.bat"

if (Test-Path $startupScript) {
    & $startupScript
    if ($LASTEXITCODE -eq 0) {
        Write-Host "✅ Tomcat iniciado correctamente."
    } else {
        Write-Host "❌ Hubo un error al iniciar Tomcat. Código: $LASTEXITCODE"
    }
} else {
    Write-Host "❌ No se encontró startup.bat en $TOMCAT_BIN"
}
