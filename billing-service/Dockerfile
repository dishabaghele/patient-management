# Step 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source and build
COPY src ./src
RUN mvn clean package -DskipTests -Dos.detected.classifier=linux-x86_64

# Step 2: Run
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=builder /app/target/billing-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 4001
EXPOSE 9001

ENTRYPOINT ["java", "-jar", "app.jar"]
