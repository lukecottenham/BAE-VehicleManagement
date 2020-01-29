FROM openjdk:8-jdk-alpine AS run
COPY --from /build/target/*.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
