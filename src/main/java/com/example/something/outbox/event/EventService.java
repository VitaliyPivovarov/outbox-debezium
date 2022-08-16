package com.example.something.outbox.event;

import com.example.something.outbox.dao.OutboxEntity;
import com.example.something.outbox.dao.OutboxEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final OutboxEntityRepository outboxEntityRepository;

    @EventListener
    @Transactional
    public void handleOutboxEvent(OutboxEvent event) {
        OutboxEntity outbox = OutboxEntity.buildNew(event);
        outboxEntityRepository.save(outbox);

        /*
         * Delete the event once written, so that the outbox doesn't grow.
         * The CDC eventing polls the database log entry and not the table in the database.
         */
        outboxEntityRepository.delete(outbox);
    }
}
