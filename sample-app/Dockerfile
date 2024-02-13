# syntax=docker/dockerfile:experimental
FROM amazoncorretto:21-alpine-jdk as build
WORKDIR /workspace/app

COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src src
RUN ./gradlew build -DskipTests --no-daemon

COPY build/libs/*[^plain].jar build/application.jar
RUN java -Djarmode=layertools -jar build/application.jar extract --destination build/extracted

FROM amazoncorretto:21-alpine-jdk
RUN addgroup -S appuser && adduser -S appuser -G appuser
VOLUME /tmp
USER appuser
ARG EXTRACTED=/workspace/app/build/extracted
WORKDIR application
COPY --from=build /workspace/app/build/application.jar ./run
COPY --from=build ${EXTRACTED}/dependencies/ ./
COPY --from=build ${EXTRACTED}/spring-boot-loader/ ./
COPY --from=build ${EXTRACTED}/snapshot-dependencies/ ./
COPY --from=build ${EXTRACTED}/application/ ./
ENTRYPOINT ["java","-noverify","-XX:TieredStopAtLevel=1","-Dspring.main.lazy-initialization=true","org.springframework.boot.loader.launch.JarLauncher"]