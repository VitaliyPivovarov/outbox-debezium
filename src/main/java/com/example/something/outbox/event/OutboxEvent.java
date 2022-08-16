package com.example.something.outbox.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OutboxEvent {

    private String aggregateId;
    private String aggregateType;
    private String type;
    private String payload;
}
