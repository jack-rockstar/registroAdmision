# Build stage
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /home/app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Package stage
FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY --from=build /home/app/target/mi.registroadmision.api-0.0.1-SNAPSHOT.jar ./registroAdmision.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "registroAdmision.jar"]
