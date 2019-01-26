FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/cloud-zuul-0.0.1-SNAPSHOT.jar cloud-zuul-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cloud-zuul-0.0.1-SNAPSHOT.jar"]