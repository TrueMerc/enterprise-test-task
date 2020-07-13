package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "enterprise_test.administrative_divisions")
public class AdministrativeUnit extends AbstractEntity {
    @NonNull
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<District> districts = new ArrayList<>();

    public AdministrativeUnit() {}
}
