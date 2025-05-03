#!/bin/bash
# filepath: deploy.sh

# Vars

TOMCAT_HOME="/home/lost/Documents/apache-tomcat-9.0.1"
TOMCAT_BIN="$TOMCAT_HOME/bin"
APP_NAME="virtual-library"
DEPLOY_DIR="$TOMCAT_HOME/webapps/$APP_NAME"
RESOURCES_SOURCE_DIR="src/sh/losti/webapp/WEB-INF/resources/books"
BOOK_RESOURCES_DEPLOY_DIR="$DEPLOY_DIR/WEB-INF/resources/books"

# ——— Killer de Apache Tomcat ———
echo "🔍 Buscando procesos de Apache Tomcat..."
# Busca sólo líneas con org.apache.catalina.startup.Bootstrap (evita el grep mismo)
pids=$(ps aux \
       | grep '[o]rg.apache.catalina.startup.Bootstrap' \
       | awk '{print $2}')

if [ -z "$pids" ]; then
  echo "✔️  No se encontraron procesos de Tomcat en ejecución."
else
  for pid in $pids; do
    # Muestra info del proceso
    cmdline=$(ps -p "$pid" -o cmd=)
    echo "🗡️  Terminando Tomcat (PID $pid): $cmdline"
    kill "$pid" 2>/dev/null

    # Espera un momento y comprueba si sigue vivo
    sleep 1
    if kill -0 "$pid" 2>/dev/null; then
      echo "⚠️  PID $pid no terminó con TERM, forzando con KILL -9"
      kill -9 "$pid" 2>/dev/null
    fi
  done
  echo "✅ Procesos de Tomcat detenidos."
fi

# Compilaciòn

echo "🔍 Compilando proyecto..."

rm -rf bin

javac -Xlint:none -d bin -cp "lib/*" $(find src/sh/losti/app -name '*.java')

echo "✅ Compilacion terminada!"

# Cargar las variables al archivo setenv.sh

./scripts/mount-env.sh "$SETENV_SH"

# 📌 Despliegue de la aplicación
echo "Limpiando despliegue anterior..."
rm -rf "$DEPLOY_DIR"
mkdir -p "$DEPLOY_DIR/WEB-INF/classes/sh/losti"
mkdir -p "$DEPLOY_DIR/WEB-INF/lib"
mkdir -p "$DEPLOY_DIR/WEB-INF/resources"

# Copiar archivos JSP y recursos estáticos
cp -r src/sh/losti/webapp/* "$DEPLOY_DIR"
# Copiar archivos compilados al directorio WEB-INF/classes
cp -r bin/sh/losti/app "$DEPLOY_DIR/WEB-INF/classes/sh/losti/"
# Copiar dependencias al directorio WEB-INF/lib
cp -r lib/*.jar "$DEPLOY_DIR/WEB-INF/lib"
# Copiar archivos PDF protegidos
cp -r "$RESOURCES_SOURCE_DIR"/* "$BOOK_RESOURCES_DEPLOY_DIR"



echo "✅ Despliegue completado en $DEPLOY_DIR"