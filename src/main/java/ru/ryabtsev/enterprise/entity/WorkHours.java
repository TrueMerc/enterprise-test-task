package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "enterprise_test.work_hours")
public class WorkHours extends AbstractEntity {
    @NonNull
    @Column(name = "start_time")
    private LocalTime startTime;

    @NonNull
    @Column(name = "end_time")
    private LocalTime endTime;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Employee> employees = new ArrayList<>();

    public WorkHours() {}

    @Override
    public String toString() {
        return startTime + " - " + endTime;
    }
}
