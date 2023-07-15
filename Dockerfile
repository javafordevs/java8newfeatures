FROM openjdk:8
EXPOSE 8080
ADD target/java8features.jar java8features.jar
ENTRYPOINT [ "java","-jar","java8features.jar"]