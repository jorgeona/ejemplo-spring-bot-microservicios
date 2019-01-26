FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/cloud-eureka-0.0.1-SNAPSHOT.jar cloud-eureka-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cloud-eureka-0.0.1-SNAPSHOT.jar"]