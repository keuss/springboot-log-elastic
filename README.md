# springboot-log-elastic

springboot-log-elastic

POC with SpringBoot (2.5.0) simple API App with [Elastic stack](https://www.elastic.co/fr/) (everything in docker)

## Stack

 - Logback with [LogstashEncoder](https://github.com/logstash/logstash-logback-encoder)
 - [Elastic with docker](https://github.com/deviantony/docker-elk) with xpack.license basic
 - Logstash with [GELF](https://docs.docker.com/config/containers/logging/gelf/) log driver
 - Index "logback-*"

## URLs

 - API Swagger to add data http://localhost:8080/swagger-ui/index.html
 - Kibana IH : http://localhost:5601/ (elastic/changeme)
