#!/bin/bash
# mount-env.sh

DEFAULT_TOMCAT_HOME="/home/lost/Documents/apache-tomcat-9.0.1"
DEFAULT_SETENV_SH="$DEFAULT_TOMCAT_HOME/bin/setenv.sh"
SETENV_SH="${1:-$DEFAULT_SETENV_SH}"

EXPECTED_VARS=("DB_URL" "DB_USER" "DB_PASSWORD")

if [ -f .env ]; then
    export $(grep -v '^#' .env | xargs)
fi

update_env_file() {
    local file="$1"

    if [ ! -f "$file" ]; then
        echo "Creando archivo: $file"
        echo "#!/bin/sh" > "$file"
        chmod +x "$file"
    fi

    declare -A current_vars
    while IFS='=' read -r key value; do
        current_vars["$key"]="$value"
    done < <(grep -E "^export DB_" "$file" | sed 's/export //g')

    for var in "${EXPECTED_VARS[@]}"; do
        new_value="${!var:-}"
        current_value="${current_vars[$var]}"
        if [[ -z "$current_value" || "$current_value" != "$new_value" ]]; then
            echo "Actualizando $var en $file"
            echo "export $var=\"$new_value\"" >> "$file"
        fi
    done
}

update_env_file "$SETENV_SH"
