package com.example.daofootwo.service;

import com.example.daofootwo.dao.EmployeeDao;
import com.example.daofootwo.dto.EmployeeDTO;
import com.example.daofootwo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeDao employeeDao;

  public EmployeeServiceImpl(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  @Transactional
  @Override
  public EmployeeDTO saveOrUpdateEmployee(EmployeeDTO employeeDTO) {
    Employee employeeToSave = convertToEntity(employeeDTO);
    Employee employeeSaved = employeeDao.saveOrUpdateEmployee(employeeToSave);
    return convertToDTO(employeeSaved);
  }

  private Employee convertToEntity(EmployeeDTO employeeDTO) {
    return new Employee(employeeDTO.employeeId(), employeeDTO.employeeName(), employeeDTO.employeeUsername(), employeeDTO.employeeEmail());
  }

  private EmployeeDTO convertToDTO(Employee employee) {
    return new EmployeeDTO(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeUsername(), employee.getEmployeeEmail());
  }
}
