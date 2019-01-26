FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/micro-instrument-0.0.1-SNAPSHOT.jar micro-instrument-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/micro-instrument-0.0.1-SNAPSHOT.jar"]