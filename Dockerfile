FROM openjdk:11
ADD target/cars-api-docker.jar cars-api-docker.jar
ENTRYPOINT ["java", "-jar","cars-api-docker.jar"]
EXPOSE 8080