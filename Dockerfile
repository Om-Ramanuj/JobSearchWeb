# Stage 1: Build the jar with Maven + Java 21
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml first to cache dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the project with full error output, skip tests
RUN mvn clean package -DskipTests -e

# Stage 2: Run the app using Java 21 runtime
FROM eclipse-temurin:21
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/JOB-0.0.1-SNAPSHOT.jar app.jar

# Set default port and expose it
ARG PORT=8080
EXPOSE ${PORT}

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
