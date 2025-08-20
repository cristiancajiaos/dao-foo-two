package com.example.daofootwo.controller;

import com.example.daofootwo.dto.EmployeeDTO;
import com.example.daofootwo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping
  public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
    try {
      List<EmployeeDTO> foundEmployees = employeeService.getAllEmployees();
      return ResponseEntity.ok(foundEmployees);
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/{employeeId}")
  public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
    try {
      EmployeeDTO foundEmployee = employeeService.getEmployeeById(employeeId);
      return ResponseEntity.ok(foundEmployee);
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.notFound().build();
    }
  }
}
