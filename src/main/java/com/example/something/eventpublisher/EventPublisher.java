package com.example.something.eventpublisher;

import com.example.something.outbox.event.OutboxEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void fire(OutboxEvent outboxEvent) {
        this.publisher.publishEvent(outboxEvent);
    }
}
