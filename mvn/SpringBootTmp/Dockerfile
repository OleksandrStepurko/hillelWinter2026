FROM eclipse-temurin:17-jre

MAINTAINER developer

# App port
EXPOSE 8080

COPY target/App-spring-boot.jar app.jar

ENTRYPOINT ["java",  "-jar", "/app.jar"]
