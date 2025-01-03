FROM openjdk:21-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Instalar netcat y dockerize
RUN apt-get update && \
    apt-get install -y netcat-openbsd curl && \
    curl -sSL https://github.com/jwilder/dockerize/releases/download/v0.6.1/dockerize-linux-amd64-v0.6.1.tar.gz | tar xz -C /usr/local/bin && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Copia el archivo JAR generado a /app en el contenedor
COPY target/nequi-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que corre la aplicación Spring Boot (default: 8080)
EXPOSE 8080


# Establece el perfil activo de Spring Boot
ENV SPRING_PROFILES_ACTIVE=dev

ENTRYPOINT ["dockerize", "-wait", "tcp://db-mysql:3306", "-timeout", "30s", "java", "-jar", "app.jar"]