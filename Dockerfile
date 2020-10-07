FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} oasis.jar
EXPOSE 8081
ENTRYPOINT {"nohup","java","-jar","/oasis.jar",">","/root/log.txt","2>&1","&"}