# DB services config
dbUrl=${dbUrl//\//\\\/}
dbUrl=${dbUrl//&/\\&}
dbConfigPath=/usr/local/tomcat/webapps/manager-consumer-node/WEB-INF/classes/config/component/dbservice.properties
sed -i 's/\(hostAndPort=\).*/\1'$dbUrl'/' $dbConfigPath

# Kafka config
kafkaConfigPath=/usr/local/tomcat/webapps/manager-consumer-node/WEB-INF/classes/config/component/kafka.properties
sed -i 's/\(bootstrap.servers=\).*/\1'$bootstrapServers'/' $kafkaConfigPath
sed -i 's/\(topic=\).*/\1'$topic'/' $kafkaConfigPath
sed -i 's/\(group.id=\).*/\1'$groupId'/' $kafkaConfigPath

# Kafka client config
kafkaClientConfigPath=/usr/local/tomcat/webapps/manager-consumer-node/WEB-INF/classes/dms_kafka_client_jaas.conf
sed -i 's/\(access_key=\).*/\1\"'$accessKey'\"/' $kafkaClientConfigPath
sed -i 's/\(secret_key=\).*/\1\"'$secretKey'\"/' $kafkaClientConfigPath
sed -i 's/\(project_id=\).*/\1\"'$projectId'\";/' $kafkaClientConfigPath

# Redis config
redisConfigPath=/usr/local/tomcat/webapps/manager-consumer-node/WEB-INF/classes/config/component/redis.properties
sed -i 's/\(redis.host=\).*/\1'$redisHost'/' $redisConfigPath
sed -i 's/\(redis.port=\).*/\1'$redisPort'/' $redisConfigPath
sed -i 's/\(redis.passwd=\).*/\1'$redisPasswd'/' $redisConfigPath
sed -i 's/\(redis.maxActive=\).*/\1'$redisMaxActive'/' $redisConfigPath