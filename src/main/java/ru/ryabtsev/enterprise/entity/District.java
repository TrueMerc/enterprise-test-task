package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "enterprise_test.districts")
public class District extends AbstractEntity {
    @NonNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    //@JoinColumn(name = "division_id", nullable = false, updatable = false)
    @JoinColumn(name = "division_id")
    private AdministrativeUnit administrativeUnit;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Address> addresses = new ArrayList<>();

    public District() {}
}
