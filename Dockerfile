FROM maven:3.8.3-openjdk-17 as builder

WORKDIR /workdir
COPY pom.xml .
COPY src ./src


RUN mvn package -DskipTests
EXPOSE 9090
FROM openjdk:17.0-jdk-slim