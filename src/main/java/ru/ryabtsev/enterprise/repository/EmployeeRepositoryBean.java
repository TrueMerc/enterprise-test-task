package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;
import ru.ryabtsev.enterprise.entity.Employee;

//import javax.ejb.Stateless;
import javax.ejb.Stateless;
import javax.faces.bean.ApplicationScoped;
import javax.management.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

/**
 * Provides 'User' entities repository implementation.
 */
@Stateless
//@ApplicationScoped
public class EmployeeRepositoryBean extends AbstractRepository implements EmployeeRepository {
    @Override
    public Employee create() {
        Employee employee = new Employee();
        super.doPersist(employee);
        return employee;
    }

    @Override
    public @NonNull Collection<Employee> getAll() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> result = query.getResultList();
        return result;
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
    public void remove(String productId) {

    }
}
