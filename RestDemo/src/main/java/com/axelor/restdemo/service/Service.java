package com.axelor.restdemo.service;

import java.util.List;

import com.axelor.restdemo.domain.Employee;

public interface Service {
  
  void insert(String name,String[] contact,String address);
  public List<Employee> showAllEmployees();
  void delete(int id);
  public List<Employee> search(String name);
 
  void update(int id,String name,String contact,String address);
  public Employee edit(int id);
  
}
