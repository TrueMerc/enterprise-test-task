package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

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

    public WorkHours() {}
}
