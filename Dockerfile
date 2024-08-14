# Use a Maven base image
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY pom.xml /app/

# Verify that pom.xml is copied
RUN ls -la /app/ && cat /app/pom.xml

# Copy the source code to the working directory
COPY src /app/src/

# Build the Maven project
RUN mvn package

# Verify that the jar file is created
RUN ls -la /app/target/ && ls -la /app/target/*.jar

# Keep the container running for manual inspection
CMD ["mvn", "package", "-X"]

