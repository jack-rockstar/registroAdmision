# Base image with Maven to build the application
FROM maven:3.8.5-openjdk-17 AS builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTests

# Final image with Java to run the application
FROM adoptopenjdk/openjdk17:alpine-jre

WORKDIR /app
COPY --from=builder /app/target/mi.registroadmision.api-0.0.1-SNAPSHOT.jar ./registroAdmision.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "registroAdmision.jar"]
