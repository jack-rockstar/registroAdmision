FROM openjdk:17-jdk-alpine
ADD target/mi.registroadmision.api-0.0.1-SNAPSHOT.jar registroAdmisionApp.jar
ENTRYPOINT ["java", "-jar", "registroAdmisionApp.jar"]