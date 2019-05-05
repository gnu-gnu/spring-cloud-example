# spring-cloud-example
Example for Spring cloud (netflix OSS, spring cloud)

This project has following components 
- eureka-server (discovery service)
  - support three peer to peer discovery
    - three server profiles included
    - each server runs with -Dspring.profiles.active=**peer1** or **peer2** or **peer3**
    - port range is 8800-8802
- eureka-client (simple backend-client)
  - three client-service profiles included
  - each server runs with -Dspring.profiles.active=**peer1** or **peer2** or **peer3**
  - port range is 8811-8813
- zuul-gateway (API Gateway)
  - port is 8888
  - request to http://localhost:8888/api/client/ping shows load-balanced responses.
- spring-config-server (file base remote config server)
  - all of configuration files are in **/src/main/resources/config**
  - runs with -Dspring.profiles.active=native
  - port is 9000
