FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/cloud-config-0.0.1-SNAPSHOT.jar cloud-config-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cloud-config-0.0.1-SNAPSHOT.jar"]