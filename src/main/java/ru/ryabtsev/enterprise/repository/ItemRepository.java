package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;

import java.util.Collection;

/**
 * Provides interface for repository of items.
 * @param <ItemType> type of given items.
 * @param <IdentifierType> type of DB identifier.
 */
public interface ItemRepository<ItemType, IdentifierType> {
    /**
     * Creates new element in repository.
     */
    @NonNull
    ItemType create();

    /**
     * Returns collection which contains all products from repository.
     * @return
     */
    @NonNull
    Collection<ItemType> getAll();

    /**
     * Returns item by its id.
     * @param id product id.
     * @return item by its id.
     */
    ItemType get(IdentifierType id);

    /**
     * Merges item into repository.
     */
    void merge(final ItemType item);

    /**
     * Persists item into repository.
     */
    void persist(final ItemType item);

    /**
     * Removes item with given id from repository.
     * @param productId product id.
     */
    void remove(String productId);
}
