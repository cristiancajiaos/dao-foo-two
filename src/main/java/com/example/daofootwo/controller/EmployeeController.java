package com.example.daofootwo.controller;

import com.example.daofootwo.dto.EmployeeDTO;
import com.example.daofootwo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping
  public ResponseEntity<EmployeeDTO> createEmployee (@RequestBody EmployeeDTO employeeDTO) {
    try {
      EmployeeDTO createdEmployee = employeeService.saveOrUpdateEmployee(employeeDTO);
      return ResponseEntity.ok(createdEmployee);
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.notFound().build();
    }
  }
}
