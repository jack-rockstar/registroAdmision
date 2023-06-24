
#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/mi.registroadmision.api-0.0.1-SNAPSHOT.jar registroAdmision.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "registroAdmision.jar"]