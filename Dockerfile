# Package stage
FROM openjdk:17.0-jdk-slim
WORKDIR /app
EXPOSE 9090
COPY target/mi.registroadmision.api-0.0.1-SNAPSHOT.jar registroAdmision.jar
ENTRYPOINT ["java", "-jar", "registroAdmision.jar"]
