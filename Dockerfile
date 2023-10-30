# This is a sample Image with openjdk:17 as the base
FROM openjdk:17-alpine
#COPY target/devops-rest-example-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
#set a docker volume
VOLUME /backend_volume
#ADD the jar file
ADD /target/*.jar DevOps_assignment1-0.0.1-SNAPSHOT.jar
#start the app
ENTRYPOINT ["java","-jar","/DevOps_assignment1-0.0.1-SNAPSHOT.jar"]
#CMD java -jar app.jar

FROM maven:3.9.4-eclipse-temurin-17-alpine AS build
RUN mkdir-p/app
WORKDIR /app
COPY pom.xml /app
COPY src /app/src
RUN mvn-B package--file pom.xml-DskipTests

FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8088
COPY--from=build /app/target/*jar cicd-demo-1.3.jar
ENTRYPOINT["java","-jar","cicd-demo-1.3.jar"]
