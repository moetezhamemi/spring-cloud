#Start with a base image containing Java runtime
FROM openjdk:21
#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="moetez.com"
# Add the application's jar to the image
COPY target/type-microservice-0.0.1-SNAPSHOT.jar type-microservice-0.0.1-SNAPSHOT.jar
# execute the application
ENTRYPOINT ["java", "-jar", "type-microservice-0.0.1-SNAPSHOT.jar"]