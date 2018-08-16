package com.huawei.manager;

import com.huawei.configbean.KafkaConfigBean;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaManager {

    private static Logger log = Logger.getLogger(KafkaManager.class);

    private KafkaConfigBean kafkaConfigBean;

    private KafkaProducer<String,String> kafkaProducer = null;

    private String topic = "";

    public void setKafkaConfigBean(KafkaConfigBean kafkaConfigBean) {
        this.kafkaConfigBean = kafkaConfigBean;
    }

    private  void initKafkaClient(){
        if(kafkaProducer == null){
            Properties producerConfig = kafkaConfigBean.getProducerConfig();
            topic = producerConfig.getProperty("topic");
            kafkaProducer = new KafkaProducer<>(producerConfig);
        }
    }

    public boolean produceMsg(String msg){
        boolean result = false;
        try {
            Future<RecordMetadata> future =
                    kafkaProducer.send(new ProducerRecord<String, String>(topic,null, msg));
            RecordMetadata rm = future.get();
            result = true;
            log.info("Succeed to send msg: " + rm.offset());
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
        }
        return result;
    }
}
