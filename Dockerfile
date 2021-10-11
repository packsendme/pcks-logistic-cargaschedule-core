
FROM openjdk:8-jdk-alpine
EXPOSE 9179
COPY /target/pcks-logistic-scheduling-core-0.0.1-SNAPSHOT.jar pcks-logistic-scheduling-core-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/pcks-logistic-scheduling-core-0.0.1-SNAPSHOT.jar"]
