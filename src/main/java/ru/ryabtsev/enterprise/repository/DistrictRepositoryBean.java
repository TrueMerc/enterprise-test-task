package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;
import ru.ryabtsev.enterprise.entity.District;

import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class DistrictRepositoryBean extends AbstractRepository implements DistrictRepository {
    @Override
    public District create() {
        District district = new District();
        super.doPersist(district);
        return district;
    }

    @Override
    public @NonNull Collection<District> getAll() {
        return entityManager.createQuery("SELECT d FROM District d", District.class).getResultList();
    }

    @Override
    public District get(Long id) {
        return entityManager.find(District.class, id);
    }

    @Override
    public District get(String name) {
        return entityManager.createQuery("SELECT d FROM District d WHERE d.name LIKE :name", District.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public void merge(District item) {
        entityManager.merge(item);
    }

    @Override
    public void persist(District item) {
        entityManager.persist(item);
    }

    @Override
    public void remove(Long id) {
        final District district = this.get(id);
        if( district != null) {
            super.doRemove(district);
        }
    }
}
