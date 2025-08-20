package com.example.daofootwo.service;

import com.example.daofootwo.dto.EmployeeDTO;
import com.example.daofootwo.entity.Employee;
import java.util.List;

public interface EmployeeService {

  EmployeeDTO saveOrUpdateEmployee(EmployeeDTO employeeDTO);

  List<EmployeeDTO> getAllEmployees();

  EmployeeDTO getEmployeeById(Long employeeId);

  /*
  void deleteEmployee(Employee employee);
   */

}
