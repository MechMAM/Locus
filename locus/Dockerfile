FROM maven:latest as build
WORKDIR /workspace/app

COPY /mvnw /workspace/app
COPY .mvn /workspace/app/.mvn
COPY /pom.xml /workspace/app
COPY src /workspace/app/src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target
COPY --from=build ${DEPENDENCY}/classes/application.properties /app/aplication.properties
COPY --from=build ${DEPENDENCY}/classes/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/*.jar /app.jar

EXPOSE 8080/tcp

CMD ["java", "-Dservices.locus_api.port=8080","-jar", "/app.jar"]