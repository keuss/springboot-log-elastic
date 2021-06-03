# springboot-log-elastic

springboot-log-elastic

POC with SpringBoot (2.5.0) simple API App with [Elastic stack](https://www.elastic.co/fr/) (everything in docker)

## Stack

 - Logback with [LogstashEncoder](https://github.com/logstash/logstash-logback-encoder)
 - [Elastic with docker](https://github.com/deviantony/docker-elk) with xpack.license basic
 - Logstash with [GELF](https://docs.docker.com/config/containers/logging/gelf/) log driver
 - Index "logback-*"

## URLs

 - API Swagger to add data : http://localhost:8080/swagger-ui/index.html
 - Kibana : http://localhost:5601/ (elastic/changeme), add sample data first, then create logback-* index

## Links

### Logback

 - https://www.baeldung.com/logback
 - https://github.com/logstash/logstash-logback-encoder
 - https://www.innoq.com/en/blog/structured-logging/ (nice feature like keyValue, ...)
 - https://dev.to/anandsunderraman/json-logging-in-spring-boot-applications-2j33

### Send the Logs of a Java App to the Elastic Stack

 - https://www.baeldung.com/java-application-logs-to-elastic-stack	
 - https://medium.com/@ridwanfajar/send-your-container-logs-to-elk-elasticsearch-logstash-and-kibana-with-gelf-driver-7995714fbbad

### GELF

 - https://docs.docker.com/config/containers/logging/gelf/
 - https://stackoverflow.com/questions/44050803/unable-to-connect-docker-container-to-logstash-via-gelf-driver
 - https://www.docker.com/blog/adventures-in-gelf/

