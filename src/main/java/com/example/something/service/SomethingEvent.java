package com.example.something.service;

import com.example.something.dao.SomethingEntity;
import com.example.something.outbox.event.OutboxEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomethingEvent {

    private final ObjectMapper objectMapper;

    public OutboxEvent createEvent(SomethingEntity somethingEntity) {
        String json = objectMapper.convertValue(somethingEntity, JsonNode.class).toString();

        return new OutboxEvent(
                somethingEntity.getId(),
                "something",
                "something_created",
                json
        );
    }

    public OutboxEvent updateEvent(SomethingEntity somethingEntity) {
        String json = objectMapper.convertValue(somethingEntity, JsonNode.class).toString();

        return new OutboxEvent(
                somethingEntity.getId(),
                "something",
                "something_updated",
                json
        );
    }
}
