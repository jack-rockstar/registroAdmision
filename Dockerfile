FROM openjdk:11
WORKDIR /app
COPY --from=build /home/app/target/mi.registroadmision.api-0.0.1-SNAPSHOT.jar ./registroAdmision.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "registroAdmision.jar"]