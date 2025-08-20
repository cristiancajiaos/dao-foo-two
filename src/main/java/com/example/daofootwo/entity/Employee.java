package com.example.daofootwo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "employees")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employee_id")
  private Long employeeId;

  @Column(name = "employee_name")
  private String employeeName;

  @Column(name = "employee_username")
  private String employeeUsername;

  @Column(name = "employee_email")
  private String employeeEmail;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private Timestamp createdAt;

  @Column(name = "updated_at")
  private Timestamp updatedAt;

  public Employee() {
  }

  public Employee(Long employeeId, String employeeName, String employeeUsername,
      String employeeEmail) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.employeeUsername = employeeUsername;
    this.employeeEmail = employeeEmail;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getEmployeeUsername() {
    return employeeUsername;
  }

  public void setEmployeeUsername(String employeeUsername) {
    this.employeeUsername = employeeUsername;
  }

  public String getEmployeeEmail() {
    return employeeEmail;
  }

  public void setEmployeeEmail(String employeeEmail) {
    this.employeeEmail = employeeEmail;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "employeeId=" + employeeId +
        ", employeeName='" + employeeName + '\'' +
        ", employeeUsername='" + employeeUsername + '\'' +
        ", employeeEmail='" + employeeEmail + '\'' +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        '}';
  }
}
