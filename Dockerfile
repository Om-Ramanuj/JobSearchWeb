# Use lightweight Java 21 image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/JOB-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Command to run the app
CMD ["java", "-jar", "app.jar"]
