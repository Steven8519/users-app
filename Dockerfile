FROM openjdk:11.0.4-jre-slim-buster

COPY target/developerhub-user-service-0.0.1-SNAPSHOT.jar webapp.jar

EXPOSE 8080

CMD ["java","-jar","webapp.jar"]