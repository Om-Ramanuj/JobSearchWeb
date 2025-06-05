FROM amazoncorretto:17

# Copy the fat jar into the container
COPY target/JOB-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on (default Spring Boot port is 8080)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
