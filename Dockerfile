FROM adoptopenjdk/openjdk11:jre-nightly
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/cardizpsj.jar
WORKDIR /app
ENV DATABASE_USERNAME=
ENV DATABASE_PASSWORD=
ENV DATABASE_URL=
ENV PORT=
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cardizpsj.jar"]