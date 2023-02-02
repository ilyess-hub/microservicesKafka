FROM openjdk:11
COPY target/*.jar producer-service.jar
ENTRYPOINT ["java","-jar","/producer-service.jar"]
EXPOSE 9090