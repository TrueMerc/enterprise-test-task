package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "enterprise_test.districts")
public class District extends AbstractEntity {

    @NonNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false, updatable = false)
    AdministrativeUnit administrativeDivision;

    public District() {}
}
