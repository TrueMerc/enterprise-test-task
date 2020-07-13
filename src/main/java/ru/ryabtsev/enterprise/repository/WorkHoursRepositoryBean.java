package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;
import ru.ryabtsev.enterprise.entity.WorkHours;

import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class WorkHoursRepositoryBean extends AbstractRepository implements WorkHoursRepository {
    @Override
    public WorkHours create() {
        return null;
    }

    @Override
    public @NonNull Collection<WorkHours> getAll() {
        return entityManager.createQuery("SELECT w FROM WorkHours w", WorkHours.class).getResultList();
    }

    @Override
    public WorkHours get(Long id) {
        return entityManager.find(WorkHours.class, id);
    }

    @Override
    public void merge(WorkHours item) {
        doMerge(item);
    }

    @Override
    public void persist(WorkHours item) {
        doMerge(item);
    }

    @Override
    public void remove(Long id) {
        doRemove(id);
    }
}
