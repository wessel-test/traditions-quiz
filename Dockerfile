# Use the official OpenJDK image as a base
FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && apt-get install -y maven && apt-get clean;

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY pom.xml .

# Resolve dependencies in the pom.xml file
RUN mvn dependency:resolve

# Copy the source code to the working directory
COPY src src

# Build the project and skip tests
RUN mvn package -DskipTests

# Expose port 8080 for the application
EXPOSE 8080

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "target/traditions-quiz.jar"]
