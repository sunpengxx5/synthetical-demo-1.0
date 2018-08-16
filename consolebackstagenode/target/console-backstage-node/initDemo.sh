#Manager services config
managerServicesUrl=${managerServicesUrl//\//\\\/}
managerServicesUrl=${managerServicesUrl//&/\\&}
managerServicesConfigPath=/usr/local/tomcat/webapps/ROOT/WEB-INF/classes/config/managerservices.properties
sed -i 's/\(managerServicesUrl=\).*/\1'$managerServicesUrl'/' $managerServicesConfigPath

#Db services config
dbServicesUrl=${dbServicesUrl//\//\\\/}
dbServicesUrl=${dbServicesUrl//&/\\&}
dbServicesConfigPath=/usr/local/tomcat/webapps/ROOT/WEB-INF/classes/config/dbservices.properties
sed -i 's/\(hostAndPort=\).*/\1'$dbServicesUrl'/' $dbServicesConfigPath

# Redis config
redisConfigPath=/usr/local/tomcat/webapps/ROOT/WEB-INF/classes/config/redis.properties
sed -i 's/\(redis.host=\).*/\1'$redisHost'/' $redisConfigPath
sed -i 's/\(redis.port=\).*/\1'$redisPort'/' $redisConfigPath
sed -i 's/\(redis.passwd=\).*/\1'$redisPasswd'/' $redisConfigPath
sed -i 's/\(redis.maxActive=\).*/\1'$redisMaxActive'/' $redisConfigPath
