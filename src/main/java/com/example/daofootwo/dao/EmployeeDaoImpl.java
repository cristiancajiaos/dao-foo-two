package com.example.daofootwo.dao;

import com.example.daofootwo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Employee saveOrUpdateEmployee(Employee employee) {
    Employee employeeDB = em.merge(employee);
    return employeeDB;
  }

  @Override
  public List<Employee> getAllEmployees() {
    TypedQuery<Employee> employeeTypedQuery = em.createQuery("FROM Employee", Employee.class);
    return employeeTypedQuery.getResultList();
  }

  @Override
  public Employee getEmployeeById(Long employeeId) {
    return null;
  }

  @Override
  public void deleteEmployee(Employee employee) {

  }
}
