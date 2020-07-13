package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "enterprise_test.administrative_divisions")
public class AdministrativeUnit extends AbstractEntity {

    @NonNull
    @Column(name = "name")
    private String name;

    public AdministrativeUnit() {}
}
