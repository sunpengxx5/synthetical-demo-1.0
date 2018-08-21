FROM tomcat:9.0
WORKDIR /usr/local/tomcat/webapps/ROOT

# DB services
ENV dbUrl http://db-control-node:8080

# Kafka
ENV bootstrapServers dms-kafka.cn-north-1.myhuaweicloud.com:37000
ENV topic k-0e964f1ae251477ebbfe8cd85e758ee6-26c0bbc2-101b-406e-a0a2-c9dbf18a3bbd
ENV groupId g-dff62419-c19a-4ae1-ade3-e3668a9df87d
# Kafka client
ENV accessKey G14IYNXRHFV9ISEWHEMW
ENV secretKey ZGaTtLs1KwcRCOlfmzFMBJ9lqbsZJoyU3Kcgr5gh
ENV projectId 0e964f1ae251477ebbfe8cd85e758ee6

# Redis
ENV redisHost redis-a231e00-dcs-rcwm.dcs.huaweicloud.com
ENV redisPort 6379
ENV redisPasswd Ddm@cloud2017
ENV redisMaxActive 250

RUN rm -rf /usr/local/tomcat/webapps/ROOT/*
COPY managernode/target/manager-node $WORKDIR
RUN sed -i "2i /usr/local/tomcat/webapps/ROOT/initDemo.sh" /usr/local/tomcat/bin/catalina.sh
RUN chmod 777 /usr/local/tomcat/webapps/ROOT/initDemo.sh

CMD ["catalina.sh", "run"]