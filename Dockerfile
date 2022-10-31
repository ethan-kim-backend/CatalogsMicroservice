FROM openjdk:17-ea-11-slim
VOLUME /tmp
COPY build/libs/CatalogsMicroservice-1.0.jar CatalogService.jar
ENTRYPOINT ["java","-jar","UserService.jar"]