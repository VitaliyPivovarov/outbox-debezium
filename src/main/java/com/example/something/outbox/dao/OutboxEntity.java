package com.example.something.outbox.dao;

import com.example.something.outbox.event.OutboxEvent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "outbox")
@Getter
@Setter
public class OutboxEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;

    @Column(name = "aggregateid")
    @NotBlank
    private String aggregateId;

    @Column(name = "aggregatetype")
    @NotBlank
    private String aggregateType;

    @Column(name = "type")
    @NotBlank
    private String type;

    @Column(name = "payload")
    @NotNull
    private String payload;

    public static OutboxEntity buildNew(OutboxEvent event) {
        OutboxEntity outbox = new OutboxEntity();
        outbox.setAggregateId(event.getAggregateId());
        outbox.setAggregateType(event.getAggregateType());
        outbox.setType(event.getType());
        outbox.setPayload(event.getPayload());
        return outbox;
    }
}
