FROM maven:latest AS build-stage
COPY . /build
WORKDIR /build
RUN mvn clean package

FROM java:8 AS runtime
WORKDIR /run
COPY --from=build-stage /build/target/HelpQueueApplication-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "/usr/bin/java", "-jar", "app.jar" ]