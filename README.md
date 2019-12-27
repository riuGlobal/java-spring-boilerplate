## Run project

To run project. Run in the project's root:

```
mvn spring-boot:run
```

## Deploy with Docker

Build and run the image with the following command:

```
docker build -t riunturi:dev . && docker run --rm -d -p 8080:8080 --name riunturi-dev -e ENV_FILE=.dev.application.properties riunturi:dev
```

## Environments

An environment file can be supplied by supplying the ENV_FILE argument when running the image. For example to use .prod.application.properties. Run the following command to build and run the image: 

```
docker build -t riunturi:prod . && docker run --rm -d -p 8080:8080 --name riunturi-prod -e ENV_FILE=.prod.application.properties riunturi:prod
```

**NOTE :** ENV_FILE does't accept application.properties as argument. 


## Toubleshooting

* check main Class is defined correctly in pom.xml
