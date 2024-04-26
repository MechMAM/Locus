FROM maven:latest as build
WORKDIR /workspace/app

COPY ../mvnw /workspace/app
COPY ../.mvn /workspace/app/.mvn
COPY ../pom.xml /workspace/app
RUN mvn -B dependency:resolve dependency:resolve-plugins

COPY ../src /workspace/app/src
COPY ../src/main/resources/application-production.properties /workspace/app/src/main/resources/application.properties

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

# ARG DEPENDENCY=/workspace/app/target
COPY --from=build /workspace/app/target/classes/application-production.properties /app/aplication.properties
COPY --from=build /workspace/app/target/classes/META-INF /app/META-INF
COPY --from=build /workspace/app/target/*.jar /app.jar

EXPOSE 8080/tcp

CMD ["java", "-jar", "/app.jar"]