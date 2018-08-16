package com.huawei.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huawei.Utils.CommonUtils;
import com.huawei.configbean.KafkaConfigBean;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.Future;

public class KafkaManager {

    private static Logger log = Logger.getLogger(KafkaManager.class);

    private KafkaConfigBean kafkaConfigBean;

    private KafkaProducer<String,String> kafkaProducer = null;
    private KafkaConsumer<String, String> kafkaConsumer = null;

    private String topic = "";

    public KafkaManager(){

    }

    public void setKafkaConfigBean(KafkaConfigBean kafkaConfigBean) {
        this.kafkaConfigBean = kafkaConfigBean;
    }

    private  void initKafkaClient(){
        if(kafkaConsumer == null) {
            Properties consumerConfig = kafkaConfigBean.getConsumerConfig();
            kafkaConsumer = new KafkaConsumer<>(consumerConfig);
            kafkaConsumer.listTopics();
            try {
                kafkaConsumer.subscribe(Arrays.asList(consumerConfig.getProperty("topic")), new ConsumerListener());
            }catch (Exception e){
                log.error(e);
                e.printStackTrace();
            }
        }

        if(kafkaProducer == null){
            Properties producerConfig = kafkaConfigBean.getProducerConfig();
            topic = producerConfig.getProperty("topic");
            kafkaProducer = new KafkaProducer<>(producerConfig);
        }
    }

    private class ConsumerListener implements ConsumerRebalanceListener{

        @Override
        public void onPartitionsRevoked(Collection<TopicPartition> collection) {

        }

        @Override
        public void onPartitionsAssigned(Collection<TopicPartition> collection) {

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


    public synchronized JSONArray consumeMsg(int timeout){
        JSONArray jsonArray = new JSONArray();
        try {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(timeout);
            Iterator<ConsumerRecord<String, String>> it = records.iterator();
            while(it.hasNext()){
                ConsumerRecord<String, String> cr = it.next();
                if(!cr.value().equals(CommonUtils.HEARTBEAT)){
                    jsonArray.add(JSONObject.parseObject(cr.value()));
                }
                log.info(cr.value());
            }
            kafkaConsumer.commitSync();
            log.info("Consume success!Msg count:" + jsonArray.size());
        }catch (Exception e){
            log.error("consumeMsg:" + e);
            e.printStackTrace();
        }
        return jsonArray;
    }

    public synchronized String subscription(){
        String result = null;
        try {
            Set<String> set = kafkaConsumer.subscription();
            result = set.iterator().next();
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
        }
        return result;
    }
}
