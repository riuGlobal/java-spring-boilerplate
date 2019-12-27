FROM maven:3.6.3-jdk-11

LABEL mainteiner="riu.global@gmail.com"

WORKDIR /var/www/html/riunturi

COPY ./ ./

ENV ENV_FILE=./src/main/resources/.application.properties.dev

EXPOSE 8080

CMD cp ${ENV_FILE} ./src/main/resources/application.properties && mvn spring-boot:run
