# FROM openjdk:8   
# ADD target/VehicleManagement.jar VehicleManagement.jar   
# EXPOSE 8085   
# ENTRYPOINT ["java","-jar","VehicleManagement.jar"]
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
