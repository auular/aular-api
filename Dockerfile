FROM openjdk:11-jre

RUN mkdir app

ADD /target/aular-0.0.1-SNAPSHOT.jar /app/aular.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar aular.jar"]