FROM openjdk:20
WORKDIR /app
COPY target/tarefa1-0.0.1-SNAPSHOT.jar /app/tarefa1.jar
ENTRYPOINT ["java", "-jar", "tarefa1.jar"]
