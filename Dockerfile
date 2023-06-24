# Etapa 1: Construcción sin ejecutar las pruebas
FROM maven:3.8.4-openjdk-11-slim AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src/ /app/src/
RUN mvn clean package -Dmaven.test.skip=true

# Etapa 2: Ejecución de las pruebas
FROM builder AS tester

WORKDIR /app

COPY --from=builder /app/target/ /app/target/
RUN mvn test

# Etapa 3: Etapa de producción
FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=builder /app/target/ /app/target/
COPY --from=tester /app/target/ /app/target/

EXPOSE 8080

CMD ["java", "-jar", "target/nombre_de_tu_app.jar"]
