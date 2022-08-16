package com.example.something.service;

import com.example.something.conroller.something.dto.SomethingCreateUpdateDto;
import com.example.something.dao.SomethingEntity;
import com.example.something.dao.SomethingEntityRepository;
import com.example.something.eventpublisher.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SomethingService {

    private final ModelMapper modelMapper;
    private final EventPublisher eventPublisher;
    private final SomethingEntityRepository somethingEntityRepository;
    private final SomethingEvent somethingEvent;

    @Transactional
    public SomethingEntity create(SomethingCreateUpdateDto createDto) {
        SomethingEntity somethingEntity = SomethingEntity.build(createDto.getName());
        somethingEntityRepository.save(somethingEntity);

        eventPublisher.fire(somethingEvent.createEvent(somethingEntity));
        return somethingEntity;
    }

    @Transactional
    public SomethingEntity update(String uid, SomethingCreateUpdateDto updateDto) {
        SomethingEntity somethingEntity = somethingEntityRepository.findById(uid)
                .orElseThrow(() -> new RuntimeException(String.format("Something with id:%s not found!", uid)));

        modelMapper.map(updateDto, somethingEntity);
        somethingEntity = somethingEntityRepository.save(somethingEntity);

        eventPublisher.fire(somethingEvent.updateEvent(somethingEntity));
        return somethingEntity;
    }
}
