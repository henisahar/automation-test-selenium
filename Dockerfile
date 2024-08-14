# Stage 1: Build Stage
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml /app/
RUN mvn dependency:go-offline

# Copy the source code and build the project
COPY src /app/src/
RUN mvn package

# Stage 2: Runtime Stage
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
