FROM maven:3-openjdk-17 as build-image

WORKDIR /to-build-app

COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src

RUN mvn package -DskipTests


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build-image /to-build-app/target/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]