FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app

# Copy only the pom.xml first and resolve dependencies
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B

# Now copy the source code and build the project
COPY ./src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/*.jar pipeline.jar

EXPOSE 8080
CMD ["java", "-jar", "pipeline.jar"]