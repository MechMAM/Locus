FROM maven:latest as build
WORKDIR /workspace/app

COPY /mvnw /workspace/app
COPY .mvn /workspace/app/.mvn
COPY /pom.xml /workspace/app
COPY src /workspace/app/src

RUN mvn clean package -DskipTests
# RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target
COPY --from=build ${DEPENDENCY}/classes/application.properties /app/aplication.properties
COPY --from=build ${DEPENDENCY}/classes/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/*.jar /app.jar

EXPOSE 8080/tcp

CMD ["java", "-Dservices.locus_api.port=8080","-jar", "/app.jar"]


# ENTRYPOINT ["java","-cp","app/LocusApplication.class"]
# COPY --from=build ${DEPENDENCY}/*.jar /app.jar
# COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
# COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# ENV JAVA_APP_JAR="/deployments/locus-run.jar"

# FROM amazoncorretto:20

# COPY --chown=185 --from=build /app/target/quarkus-app/lib/ /deployments/lib/
# COPY --chown=185 --from=build /app/target/quarkus-app/*.jar /deployments/
# COPY --chown=185 --from=build /app/target/quarkus-app/app/ /deployments/app/
# COPY --chown=185 --from=build /app/target/quarkus-app/quarkus/ /deployments/quarkus/

# EXPOSE $PORT
# USER root

# ENV AB_JOLOKIA_OFF=""

# ENV JAVA_VERSION=17
# ENV PORT="8080"
# ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 -Dquarkus.http.port=3000 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
# ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

# CMD ["java", "-Dquarkus.http.port=3000", "-jar", "/deployments/quarkus-run.jar"]