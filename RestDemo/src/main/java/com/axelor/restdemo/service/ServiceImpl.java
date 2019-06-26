package com.axelor.restdemo.service;

import javax.persistence.EntityManager;

import com.axelor.restdemo.domain.Address;
import com.axelor.restdemo.domain.Employee;
import com.axelor.restdemo.domain.Phone;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

@Singleton
public class ServiceImpl implements Service {

  @Inject Provider<EntityManager> entityManagerProvider;

  EntityManager entityManager;
  int id = 0;
  int id_address = 0;

  Address address;
  Employee employee;

  @Transactional(rollbackOn = Exception.class)
  @Override
  public void insert(String name, String contact, String address) {
    List<Phone> phoneList = new ArrayList<>();
    entityManager = entityManagerProvider.get();

    employee = new Employee();
    employee.setName(name);

    phoneList.add(new Phone(contact));
    employee.setPhone(phoneList);

    @SuppressWarnings("unchecked")
    List<Address> cityList =
        entityManager.createQuery("from Address a where a.city='" + address + "'").getResultList();

    if (cityList.isEmpty()) {

      this.address = new Address();
      this.address.setCity(address);

    } else {

      this.address = cityList.get(0);

    }
    employee.setAddress(this.address);
    entityManager.persist(employee);
  }

  @Override
  public List<Employee> showAllEmployees() {
    entityManager = entityManagerProvider.get();
    List<Employee> employeeList = new ArrayList<>();

    employeeList = entityManager.createQuery("from Employee").getResultList();

    return employeeList;
  }

  @Override
  public void delete(int id) {
    entityManager = entityManagerProvider.get();
    employee = entityManager.find(Employee.class, id);
    System.out.println("inside deleteimpl" );  
    if (employee != null) {
      entityManager.remove(employee);
      System.out.println("user is deleted");
  }
  }
}
