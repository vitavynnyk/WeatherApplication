FROM openjdk:17-alpine3.14
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","/app.jar"]


