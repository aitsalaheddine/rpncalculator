# RPN Kata

Hexagonal bank kata
[Requirements can be foud here](https://en.wikipedia.org/wiki/Reverse_Polish_notation#Practical_implications
)

## How to launch you dev environment

## Required software

Java 17 ([eclipse temurin JDK](https://projects.eclipse.org/projects/adoptium.temurin/downloads))

A java compatible ide of your choosing

### Rest API

Create an .env file following the example in rest/src/main/resources,
and the .env-* files in the deployment/dev-env-rest folder
then you have two options :

- Run as a docker container
````
docker build -t rpn-app .
docker run -p 8080:8080 rpn-app
````

The API embeds a swagger accessible at http://localhost:8080/swagger-ui/index.html#/
by default