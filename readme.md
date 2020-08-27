Used Frameworks
SpringBoot 2.3.3
Spring Initializer
H2 Sample Database
Spring Security Basic with Thymeleaf
SpringRest
Spring JPA
Spring Unitary Tests
Mockito Tests
Cache EhCache
Spring JWT authentication token

RUN
mvn spring-boot:run or mvn package -Dmaven.test.skip=true

Docker
docker build . -t brasilprev:customerbase
docker run --publish=8081:8081 brasilprev:customerbase

TODO 
Hazelcast Cache Mechanism
Apache Kafka Distributed Message System (Pub/Sub;Queue)
Kubernetes Cluster
OAuth2 Authentication
React or Angular or VueJs frontend calls to microservices
CouchBase Integration
