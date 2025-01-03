FROM openjdk:21-slim

WORKDIR /app

RUN apt-get update && \
    apt-get install -y netcat-openbsd curl && \
    curl -sSL https://github.com/jwilder/dockerize/releases/download/v0.6.1/dockerize-linux-amd64-v0.6.1.tar.gz | tar xz -C /usr/local/bin && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

COPY target/nequi-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENV SPRING_PROFILES_ACTIVE=dev

ENTRYPOINT ["dockerize", "-wait", "tcp://db-mysql:3306", "-timeout", "30s", "java", "-jar", "app.jar"]