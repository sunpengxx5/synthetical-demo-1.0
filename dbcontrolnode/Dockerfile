FROM tomcat:9.0
WORKDIR /usr/local/tomcat/webapps/
ENV dburl jdbc:mysql:loadbalance://172.31.72.198:5066,172.31.205.225:5066/db_001?loadBalanceAutoCommitStatementThreshold=5&loadBalanceHostRemovalGracePeriod=15000&loadBalanceBlacklistTimeout=60000&loadBalancePingTimeout=5000&retriesAllDown=10&connectTimeout=10000&socketTimeout=60000
ENV dbuser ddm_001
ENV dbpwd Ddm@cloud2017
ENV DbConnectionMaxActive 250
COPY dbcontrolnode/target/ $WORKDIR
RUN sed -i "2i /usr/local/tomcat/webapps/db-control-node/initDemo.sh" /usr/local/tomcat/bin/catalina.sh
RUN chmod 777 /usr/local/tomcat/webapps/db-control-node/initDemo.sh
CMD ["catalina.sh", "run"]