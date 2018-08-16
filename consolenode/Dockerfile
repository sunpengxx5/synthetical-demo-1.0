FROM tomcat:9.0
WORKDIR /usr/local/tomcat/webapps/ROOT

ENV managerServicesUrl http://49.4.4.124:31935/manager-node

ENV consoleBackstageHost http://49.4.4.124:30002/console-backstage-node

RUN rm -rf /usr/local/tomcat/webapps/ROOT/*
COPY consolenode/target/ $WORKDIR
RUN sed -i "2i /usr/local/tomcat/webapps/ROOT/initDemo.sh" /usr/local/tomcat/bin/catalina.sh
RUN chmod 777 /usr/local/tomcat/webapps/ROOT/initDemo.sh
CMD ["catalina.sh", "run"]