FROM openjdk:17
WORKDIR /app
COPY target/*.jar /app.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","/app.jar"]

