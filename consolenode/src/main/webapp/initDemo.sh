# Manager services config
managerServicesUrl=${managerServicesUrl//\//\\\/}
managerServicesUrl=${managerServicesUrl//&/\\&}
managerConfigPath=/usr/local/tomcat/webapps/console-node/WEB-INF/classes/config/managerservices.properties
sed -i 's/\(managerServicesUrl=\).*/\1'$managerServicesUrl'/' $managerConfigPath

# Console backstage config
consoleBackstageHost=${consoleBackstageHost//\//\\\/}
consoleBackstageHost=${consoleBackstageHost//&/\\&}
consoleBackstageConfigPath=/usr/local/tomcat/webapps/console-node/WEB-INF/classes/config/consolebackstage.properties
sed -i 's/\(consoleBackstageHost=\).*/\1'$consoleBackstageHost'/' $consoleBackstageConfigPath