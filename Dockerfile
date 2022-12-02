FROM eclipse-temurin:19-focal

COPY mvnw .
COPY .mvn .mvn
COPY consumer/pom.xml .

# Maven should be executable
RUN chmod +x ./mvnw

# Download dependencies if needed (i.e. pom has changed)
RUN ./mvnw dependency:go-offline -B

# Copy application sources to docker build stage
COPY consumer/src src

# Build artifact
RUN ./mvnw package -DskipTests
RUN mv target/*.jar target/consumer-app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","target/consumer-app.jar"]