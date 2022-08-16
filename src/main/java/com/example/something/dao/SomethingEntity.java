package com.example.something.dao;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "something")
@Getter
@Setter
public class SomethingEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid2")
    @NotBlank
    private String id;

    @Column(name = "name")
    @NotBlank
    private String name;

    public static SomethingEntity build(String name) {
        SomethingEntity somethingEntity = new SomethingEntity();
        somethingEntity.setName(name);
        return somethingEntity;
    }
}
