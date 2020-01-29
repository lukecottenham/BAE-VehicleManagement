FROM openjdk:8   
ADD target/VehicleManagement.jar VehicleManagement.jar   
EXPOSE 8085   
ENTRYPOINT ["java","-jar","VehicleManagement.jar"]
