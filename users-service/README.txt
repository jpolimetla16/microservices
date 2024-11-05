POST /users - end point
GET /users?email=jpolimetla@gmail.com
dto->entity,entity->dto -use model mapper
Global exception handler - UsernameNotFoundException
mvn clean install - generate jar file
use property place holders in application.properties
pass command line arguments using mvn spring-boot:run
mvn spring-boot:run -Dspring-boot.run.arguments="--MYSQL_DATABASE=testdb"
we can use mvnw if maven is not installed.