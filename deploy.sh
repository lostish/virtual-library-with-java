#!/bin/bash
# filepath: deploy.sh

# Ruta de Tomcat
TOMCAT_HOME="/home/lost/Documents/apache-tomcat-9.0.1"

# Nombre de la aplicación
APP_NAME="virtual-library"

# Directorio de despliegue
DEPLOY_DIR="$TOMCAT_HOME/webapps/$APP_NAME"

# Limpiar despliegue anterior
rm -rf "$DEPLOY_DIR"


# Crear nuevo directorio
mkdir -p "$DEPLOY_DIR"

# Copiar archivos
cp -r WebContent/* "$DEPLOY_DIR"
cp -r bin/* "$DEPLOY_DIR/WEB-INF/classes"

echo "Despliegue completado en $DEPLOY_DIR"

# EN-TODO: Update the build script
# ES-TODO: Actualizar el script de construcciòn