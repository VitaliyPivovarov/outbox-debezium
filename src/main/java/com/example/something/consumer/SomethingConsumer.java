package com.example.something.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SomethingConsumer {

    // message consumer must be idempotent
    @KafkaListener(
            topics = "outbox.event.#{'${outbox.listen.something.event}'}",
            groupId = "#{'${spring.kafka.consumer.group-id}'}"
    )
    public void consumeSomethingCreatedEvent(String message) {
        log.info("Consume something created message:{}", message);

        // code...
    }

}


