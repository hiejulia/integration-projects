FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/kubernetes-application-1.0-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /app.jar --debug

# Docker file


# copy app.jar file to the volume mounted folder


