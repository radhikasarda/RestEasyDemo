package com.axelor.restdemo.service;

import java.util.List;

import com.axelor.restdemo.domain.Employee;

public interface Service {
  
  void insert(String name,String contact,String address);
  public List<Employee> showAllEmployees();
  void delete(int id);
  
}
