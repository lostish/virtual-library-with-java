#!/bin/bash
# filepath: start-server.sh

TOMCAT_HOME="/home/lost/Documents/apache-tomcat-9.0.1"
TOMCAT_BIN="$TOMCAT_HOME/bin"

echo "🚀 Iniciando Apache Tomcat desde: $TOMCAT_BIN"
"$TOMCAT_BIN/startup.sh"

if [ $? -eq 0 ]; then
  echo "✅ Tomcat iniciado correctamente."
else
  echo "❌ Hubo un error al iniciar Tomcat."
fi
