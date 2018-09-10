FROM tomcat:8.0.53-jre8
WORKDIR /usr/local/tomcat/webapps/ROOT

ENV managerServicesUrl http://manager-node:8080

ENV consoleBackstageHost http://console-backstage-node:8080

RUN rm -rf /usr/local/tomcat/webapps/ROOT/*

COPY consolenode/target/console-node $WORKDIR
RUN sed -i "2i /usr/local/tomcat/webapps/ROOT/initDemo.sh" /usr/local/tomcat/bin/catalina.sh
RUN chmod 777 /usr/local/tomcat/webapps/ROOT/initDemo.sh
CMD ["catalina.sh", "run"]