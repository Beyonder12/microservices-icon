package com.kafkaexperimentclient.app.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.stream.StreamSupport;

@RestController
public class KafkaClientController {
    private static final Logger logger =
            LoggerFactory.getLogger(KafkaClientController.class);

    //private CountDownLatch latch = new CountDownLatch(10);

    @KafkaListener(topics = "advice-topic", clientIdPrefix = "string",
            containerFactory = "kafkaListenerContainerFactory")
    public void listenAsObject(ConsumerRecord<String, String> cr,
                               @Payload String text) {
        logger.info("Logger 1 [JSON] received key {}: Payload: {}", cr.key(), text);
        //latch.countDown();
    }

//    @KafkaListener(topics = "advice-topic", clientIdPrefix = "bytearray",
//            containerFactory = "kafkaListenerByteArrayContainerFactory")
//    public void listenAsByteArray(ConsumerRecord<String, byte[]> cr,
//                                  @Payload byte[] payload) {
//        logger.info("Logger 2 [ByteArray] received key {}: Payload: {}", cr.key(), payload);
//        //latch.countDown();
//    }

    private static String typeIdHeader(Headers headers) {
        return StreamSupport.stream(headers.spliterator(), false)
                .filter(header -> header.key().equals("__TypeId__"))
                .findFirst().map(header -> new String(header.value())).orElse("N/A");
    }
}
