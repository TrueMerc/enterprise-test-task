package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
abstract class AbstractEntity {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    AbstractEntity() {}
}
