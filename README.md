# NewsApiExample
This application is a test for newsapi.com resources for educational purposes. 

To start, you need to (docker-compose in progress): 
1) redis on port 6379
2) postgres on port 55000
3) run script db_migration/USER_CREATE.sql
4) You need to generate and insert your API key before running in the Dockerfile.
ENV API_KEY=<INSERT_API_KEY>
or set enviroment variables for local run
5) run Dockerfile

An application provides an API through Swagger: http://localhost:8080/swagger-ui/index.html. user:user


Used libraries:
1) **spring-cloud-starter-openfeign**. One of the most popular API integration libraries. 
2) **spring-boot-starter-security** for security features.
3) **postgresql and spring-boot-starter-data-jpa** for database integration (save data for security plugin)
4) **spring-boot-starter-cache and spring-boot-starter-data-redis** for redis cashe (save data for frequent requests)
5) **springdoc-openapi-ui** for swagger
6) **spring-boot-starter-actuator and micrometer-registry-prometheus** for prometheus integration (work in progress)
