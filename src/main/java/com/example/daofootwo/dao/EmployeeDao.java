package com.example.daofootwo.dao;

import com.example.daofootwo.entity.Employee;
import java.util.List;

public interface EmployeeDao {

  Employee saveOrUpdateEmployee(Employee employee);

  List<Employee> getAllEmployees();

  Employee getEmployeeById(Long employeeId);

  void deleteEmployee(Employee employee);

}
