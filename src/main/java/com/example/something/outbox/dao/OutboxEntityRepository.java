package com.example.something.outbox.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OutboxEntityRepository extends JpaRepository<OutboxEntity, UUID> {

}
