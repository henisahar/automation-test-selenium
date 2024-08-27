
FROM maven:3.8.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml /app/

RUN ls -la /app/ && cat /app/pom.xml

COPY src /app/src/

RUN mvn package

RUN ls -la /app/target/ && ls -la /app/target/*.jar

CMD ["mvn", "package", "-X"]

