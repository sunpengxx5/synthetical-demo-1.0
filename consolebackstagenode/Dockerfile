FROM tomcat:8.0.53-jre8
WORKDIR /usr/local/tomcat/webapps/ROOT

ENV managerServicesUrl http://manager-node:8080

ENV dbServicesUrl http://db-control-node:8080

ENV redisHost redis-a231e00-dcs-rcwm.dcs.huaweicloud.com
ENV redisPort 6379
ENV redisPasswd Ddm@cloud2017
ENV redisMaxActive 20

RUN rm -rf /usr/local/tomcat/webapps/ROOT/*
COPY consolebackstagenode/target/console-backstage-node $WORKDIR
RUN sed -i "2i /usr/local/tomcat/webapps/ROOT/initDemo.sh" /usr/local/tomcat/bin/catalina.sh
RUN chmod 777 /usr/local/tomcat/webapps/ROOT/initDemo.sh
CMD ["catalina.sh", "run"]