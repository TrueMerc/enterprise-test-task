package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;
import ru.ryabtsev.enterprise.entity.AdministrativeUnit;
import ru.ryabtsev.enterprise.entity.District;

import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class AdministrativeUnitRepositoryBean extends AbstractRepository implements AdministrativeUnitRepository {
    @Override
    public AdministrativeUnit create() {
        return null;
    }

    @Override
    public @NonNull Collection<AdministrativeUnit> getAll() {
        return entityManager
                .createQuery("SELECT a FROM AdministrativeUnit a", AdministrativeUnit.class)
                .getResultList();
    }

    @Override
    public AdministrativeUnit get(Long id) {
        return entityManager.find(AdministrativeUnit.class, id);
    }

    @Override
    public AdministrativeUnit get(String name) {
        return entityManager
                .createQuery("SELECT u FROM District u WHERE u.name LIKE :name", AdministrativeUnit.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public void merge(AdministrativeUnit item) {
        doMerge(item);
    }

    @Override
    public void persist(AdministrativeUnit item) {
        doPersist(item);
    }

    @Override
    public void remove(Long id) {
        doRemove(id);
    }
}
