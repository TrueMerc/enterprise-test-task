package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;
import ru.ryabtsev.enterprise.entity.Employee;

import javax.ejb.Stateless;
import java.util.Collection;

/**
 * Provides 'User' entities repository implementation.
 */
@Stateless
public class EmployeeRepositoryBean extends AbstractRepository implements EmployeeRepository {
    @Override
    public Employee create() {
        Employee employee = new Employee();
        super.doPersist(employee);
        return employee;
    }

    @Override
    @NonNull
    public Collection<Employee> getAll() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    @Override
    public Employee get(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void merge(Employee item) {
        entityManager.merge(item);
    }

    @Override
    public void persist(Employee item) {
        entityManager.persist(item);
    }

    @Override
    public void remove(Long id) {
        final Employee product = this.get(id);
        if( product != null) {
            super.doRemove(product);
        }
    }
}
