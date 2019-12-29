## Run project

To run project. Run in the project's root:

```
mvn spring-boot:run
```

## Deploy with Docker

Build and run the image with the following command:

```
docker build -f docker/Dockerfile -t project:dev . && docker run --rm -d -p 8080:8080 --name project-dev -e ENV_FILE=.application.properties.dev project:dev
```

## Environments

An environment file can be supplied by supplying the ENV_FILE argument when running the image. For example to use .prod.application.properties. Run the following command to build and run the image: 

```
docker build -t project:prod . && docker run --rm -d -p 8080:8080 --name project-prod -e ENV_FILE=.application.properties.prod project:prod
```

**NOTE :** ENV_FILE does't accept application.properties as argument. 


## Toubleshooting

* check main Class is defined correctly in pom.xml
