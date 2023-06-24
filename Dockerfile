# Build stage
FROM maven:3.8.3-openjdk-17 as builder
WORKDIR /workdir
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Package stage
FROM openjdk:17.0-jdk-slim
WORKDIR /app
COPY --from=builder /workdir/target/mi.registroadmision.api-0.0.1-SNAPSHOT.jar ./registroAdmision.jar
#EXPOSE 9090
ENTRYPOINT ["java", "-jar", "registroAdmision.jar"]
