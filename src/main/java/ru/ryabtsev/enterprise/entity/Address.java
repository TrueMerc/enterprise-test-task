package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "enterprise_test.addresses")
public class Address extends AbstractEntity {
    @NonNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    private District district;

    @OneToMany
    private List<Employee> employees = new ArrayList<>();

    public Address() {}
}
