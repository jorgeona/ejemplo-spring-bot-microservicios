FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/micro-singer-0.0.1-SNAPSHOT.jar micro-singer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/micro-singer-0.0.1-SNAPSHOT.jar"]