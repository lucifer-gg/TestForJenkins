FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} oasis.jar
EXPOSE 8081
ENTRYPOINT {"java","-jar","/oasis.jar"}