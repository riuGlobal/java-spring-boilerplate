FROM maven:3.6.3-jdk-11 as MAVEN_BUILD

LABEL mainteiner="riu.global@gmail.com"

WORKDIR /var/www/html/build/riunturi

COPY ./ ./

RUN mvn package 

FROM openjdk:10.0.2-jre

WORKDIR /var/www/html/riunturi

COPY --from=MAVEN_BUILD /var/www/html/build/riunturi/target ./

ENV ENV_FILE=.application.properties.dev

EXPOSE 8080

RUN ls

RUN cat ./classes/${ENV_FILE} 

CMD cp ./classes/${ENV_FILE} ./application.properties && /usr/bin/java -jar ./riu-test-maker-1.0-SNAPSHOT.jar
