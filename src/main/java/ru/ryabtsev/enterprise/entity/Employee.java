package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Provides 'Employee' entity implementation.
 */
@Data
@Entity
@Table(name = "enterprise_test.employees")
public class Employee extends AbstractEntity {

    @NonNull
    @Column(name = "first_name")
    private String firstName = "";

    @NonNull
    @Column(name = "second_name")
    private String secondName = "";

    @NonNull
    @Column(name = "patronymic")
    String patronymic = "";

    @NonNull
    @Column(name = "age")
    Short age = 0;

    public Employee() {}

    public Employee(
            @NonNull final String secondName, @NonNull final String firstName, @NonNull final String patronymic,
            @NonNull final Short age
            )
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.age = age;
    }

    public Employee(@NonNull final String secondName, @NonNull final String firstName, @NonNull final Short age) {
        this(secondName, firstName, "", age);
    }
}
