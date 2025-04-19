param (
    [string]$SetenvPath = "$PSScriptRoot/../apache-tomcat-9.0.1/bin/setenv.bat"
)

function Update-EnvFile {
    param (
        [string]$FilePath
    )

    $ExpectedVars = @("DB_URL", "DB_USER", "DB_PASSWORD")

    # Crear archivo si no existe
    if (-not (Test-Path $FilePath)) {
        Write-Host "Creando archivo: $FilePath"
        "@echo off" | Out-File $FilePath -Encoding ascii
    }

    # Cargar variables desde .env
    if (Test-Path ".env") {
        Write-Host "🔍 Cargando variables de entorno desde .env..."
        Get-Content .env | Where-Object { $_ -match "=" -and $_ -notmatch "^#" } | ForEach-Object {
            $parts = $_ -split "=", 2
            $name = $parts[0].Trim()
            $value = $parts[1].Trim()
            Set-Item -Path "env:$name" -Value $value
        }
    }

    
    
    foreach ($var in $ExpectedVars) {
        $value = [Environment]::GetEnvironmentVariable($var)
        if (-not (Select-String -Path $FilePath -Pattern "set $var=")) {
            "set $var=$value" | Add-Content $FilePath -Encoding ascii
        }
    }
    Write-Host "🔍 Actualizando archivo de entorno..."
    Write-Host "✔️  Variables de entorno actualizadas en $FilePath"
}

# Ejecutar función principal con ruta recibida o por defecto
Update-EnvFile -FilePath $SetenvPath
