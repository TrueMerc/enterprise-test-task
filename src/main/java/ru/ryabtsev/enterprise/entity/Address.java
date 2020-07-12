package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "enterprise_test.addresses")
public class Address extends AbstractEntity {
    @NonNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    private District district;

    public Address() {}
}
