FROM maven:3.6.3-jdk-8 AS build 
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:8-jdk-alpine
COPY --from=build /target/java8features-0.0.1-SNAPSHOT.jar java8features.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","java8features.jar"]