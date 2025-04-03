# filepath: deploy.ps1

$TOMCAT_HOME = "C:\path\to\apache-tomcat-9.0.1"
$TOMCAT_BIN = "$TOMCAT_HOME\bin"
$APP_NAME = "virtual-library"
$DEPLOY_DIR = "$TOMCAT_HOME\webapps\$APP_NAME"
$SETENV_BAT = "$TOMCAT_BIN\setenv.bat"
$EXPECTED_VARS = @("DB_URL", "DB_USER", "DB_PASSWORD")

# Cargar variables de .env si existe
if (Test-Path .env) {
    Get-Content .env | ForEach-Object {
        if ($_ -match "^(.*)=(.*)$") {
            Set-Item -Path "Env:$($matches[1])" -Value $matches[2]
        }
    }
}

# Función para actualizar setenv.bat
function Update-EnvFile {
    param ([string]$file)

    if (-not (Test-Path $file)) {
        Write-Host "Creando archivo: $file"
        "@echo off" | Out-File -FilePath $file -Encoding utf8
    }

    $current_vars = @{}
    if (Test-Path $file) {
        Get-Content $file | ForEach-Object {
            if ($_ -match "^(set )?(DB_\w+)=(.*)$") {
                $current_vars[$matches[2]] = $matches[3]
            }
        }
    }

    foreach ($var in $EXPECTED_VARS) {
        $new_value = [System.Environment]::GetEnvironmentVariable($var)
        $current_value = $current_vars[$var]

        if ($current_value -ne $new_value) {
            Write-Host "Actualizando $var en $file"
            "set $var=$new_value" | Out-File -Append -FilePath $file -Encoding utf8
        }
    }
}

# Actualizar archivo setenv.bat
Update-EnvFile -file $SETENV_BAT

# 📌 Despliegue de la aplicación
Write-Host "Limpiando despliegue anterior..."
Remove-Item -Recurse -Force $DEPLOY_DIR -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Path $DEPLOY_DIR | Out-Null

# Copiar archivos
Copy-Item -Recurse -Path "WebContent\*" -Destination "$DEPLOY_DIR\"
Copy-Item -Recurse -Path "bin\*" -Destination "$DEPLOY_DIR\WEB-INF\classes"

Write-Host "✅ Despliegue completado en $DEPLOY_DIR"
