package ru.ryabtsev.enterprise.repository;

import ru.ryabtsev.enterprise.entity.AdministrativeUnit;
import ru.ryabtsev.enterprise.entity.District;

public interface AdministrativeUnitRepository extends ItemRepository<AdministrativeUnit, Long> {
    AdministrativeUnit get(String name);
}
