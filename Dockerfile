# Stage 1: Build the application with Maven
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final image with Java only
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=builder /app/target/mi.registroadmision.api-0.0.1-SNAPSHOT.jar ./registroAdmision.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "registroAdmision.jar"]
