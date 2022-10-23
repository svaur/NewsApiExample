# Stage-1: Build
FROM maven:latest AS build

COPY src /app/src
COPY pom.xml /app/

RUN mvn -f /app/pom.xml clean package

# Stage-2: Distribution
FROM openjdk:14

ENV API_KEY=<INSERT_API_KEY>
COPY --from=build /app/target/NewsApiExample-0.0.1-SNAPSHOT.jar /usr/local/lib/NewsApiExample.jar
EXPOSE 8080
WORKDIR /usr/local/lib
ENTRYPOINT ["java","-jar","NewsApiExample.jar"]
