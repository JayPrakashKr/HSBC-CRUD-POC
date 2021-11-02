FROM openjdk:8
ADD target/amexpoc.jar amexpoc.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "amexpoc.jar"]