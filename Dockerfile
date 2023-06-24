# Build stage
FROM maven:3.8.3-openjdk-17 as builder
WORKDIR /workdir
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Package stage
FROM openjdk:17.0-jdk-slim
WORKDIR /app
EXPOSE 9090
ADD   /workdir/target/mi.registroadmision.api-0.0.1-SNAPSHOT.jar  registroAdmision.jar
ENTRYPOINT ["java", "-jar", "registroAdmision.jar"]
