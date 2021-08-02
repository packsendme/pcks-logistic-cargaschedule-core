
FROM openjdk:8-jdk-alpine
EXPOSE 9179
COPY /target/pcks-roadway-shippingsheduling-core-0.0.1-SNAPSHOT.jar pcks-roadway-shippingsheduling-core-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/pcks-roadway-shippingsheduling-core-0.0.1-SNAPSHOT.jar"]
