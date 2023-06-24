# Etapa 1: Construcción e instalación
FROM maven:3.8.4-openjdk-17-slim AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src/ /app/src/
RUN mvn install -DskipTests

# Etapa 2: Ejecución de las pruebas
FROM builder AS tester

WORKDIR /app

COPY --from=builder /root/.m2/ /root/.m2/
COPY src/ /app/src/
RUN mvn test

# Etapa 3: Etapa de producción
FROM openjdk:17-jre-slim

WORKDIR /app

COPY --from=builder /app/target/ /app/target/
COPY --from=tester /root/.m2/ /root/.m2/

EXPOSE 8080

CMD ["java", "-jar", "target/mi.registroadmision.api-0.0.1-SNAPSHOT.jar"]
