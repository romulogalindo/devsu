# Build Stage
FROM maven:3-amazoncorretto-17 as build
WORKDIR /devsu
COPY src ./src
COPY pom.xml .
RUN mvn clean install -DskipTests

# Run Stage
FROM openjdk:17-oracle
WORKDIR /devsu
COPY --from=build /devsu/target/devsu.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx1800m", "-XX:+ExitOnOutOfMemoryError", "-jar", "devsu.jar"]
