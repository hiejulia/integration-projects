#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#COPY target/kubernetes-application-1.0-SNAPSHOT.jar app.jar
#ENV JAVA_OPTS=""
#ENTRYPOINT exec java -jar /app.jar --debug

# Docker file

# copy app.jar file to the volume mounted folder

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} kubernetes-application.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


