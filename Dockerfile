FROM adoptopenjdk/openjdk11:x86_64-ubuntu-jre-11.0.25_9
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/cardizpsj-api.jar
WORKDIR /app
ENV DATABASE_USERNAME=
ENV DATABASE_PASSWORD=
ENV DATABASE_URL=
ENV PORT=
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cardizpsj-api.jar"]