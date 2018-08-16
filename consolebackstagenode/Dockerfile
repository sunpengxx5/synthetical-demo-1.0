FROM tomcat:9.0
WORKDIR /usr/local/tomcat/webapps/

ENV managerServicesUrl http://49.4.4.124:31935/manager-demo

ENV dbServicesUrl http://49.4.4.124:31021/ddmdemo/

ENV redisHost redis-a231e00-dcs-rcwm.dcs.huaweicloud.com
ENV redisPort 6379
ENV redisPasswd Ddm@cloud2017
ENV redisMaxActive 20

COPY consolebackstagenode/target/ $WORKDIR
RUN sed -i "2i /usr/local/tomcat/webapps/console-backstage-node/initDemo.sh" /usr/local/tomcat/bin/catalina.sh
RUN chmod 777 /usr/local/tomcat/webapps/console-backstage-node/initDemo.sh
CMD ["catalina.sh", "run"]