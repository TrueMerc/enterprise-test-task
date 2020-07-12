package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Provides base implementation for repository classes.
 */
abstract class AbstractRepository {
    @PersistenceContext(unitName = "webapp-persistence-unit")
    EntityManager entityManager;

    /**
     * Returns first entity which returned for given query.
     * @param query query to database manager.
     * @param <T> entity type.
     * @return first entity which returned for given query.
     */
    <T> T getEntity(@NonNull final TypedQuery<T> query) {
        final List<T> result =query.getResultList();
        return (!result.isEmpty()) ? result.get(0) : null;
    }

    /**
     * Merges given entity from database.
     * @param entity entity to remove.
     * @param <T> entity type.
     */
    protected <T> void doMerge(@NonNull final T entity) { entityManager.merge(entity); }

    /**
     * Removes given entity from database.
     * @param entity entity to remove.
     * @param <T> entity type.
     */
    protected <T> void doRemove(@NonNull final T entity) { entityManager.remove(entity);}

    /**
     * Persists given entity from database.
     * @param entity entity to remove.
     * @param <T> entity type.
     */
    protected <T> void doPersist(@NonNull final T entity) {
        entityManager.persist(entity);
    }
}
