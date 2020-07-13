package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;
import ru.ryabtsev.enterprise.entity.AdministrativeUnit;

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
        return null;
    }

    @Override
    public void merge(AdministrativeUnit item) {

    }

    @Override
    public void persist(AdministrativeUnit item) {

    }

    @Override
    public void remove(Long id) {

    }
}
