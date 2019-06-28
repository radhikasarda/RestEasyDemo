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

	@Inject
	Provider<EntityManager> entityManagerProvider;

	EntityManager entityManager;
	int id = 0;
	int id_address = 0;

	Address address;
	Employee employee;
	

	@Transactional(rollbackOn = Exception.class)
	@Override
	public void insert(String name, String[] contact, String address) {
		List<Phone> phoneList = new ArrayList<>();
		entityManager = entityManagerProvider.get();
		//Phone phone;
		employee = new Employee();
		employee.setName(name);
		
		Phone phoneobj1 = new Phone();
		//Phone phoneobj2=new Phone();
		phoneobj1.setPhone_number(contact[0]);
		employee.getPhone().add(phoneobj1);
		phoneobj1.setEmployee(employee);

		/*
		 * phoneobj2.setPhone_number(contact[1]); employee.getPhone().add(phoneobj2);
		 * phoneobj2.setEmployee(employee)
		 */;
		@SuppressWarnings("unchecked")
		List<Address> cityList = entityManager.createQuery("from Address a where a.city='" + address + "'")
				.getResultList();

		if (cityList.isEmpty()) {

			this.address = new Address();
			this.address.setCity(address);

		} else {

			this.address = cityList.get(0);

		}
		employee.setAddress(this.address);
		System.out.println(employee);
		entityManager.persist(employee);

	}

	@Override
	@Transactional
	public List<Employee> showAllEmployees() {
		entityManager = entityManagerProvider.get();
		List<Employee> employeeList = new ArrayList<>();
		employeeList = entityManager.createQuery("from Employee").getResultList();
		return employeeList;
	}

	@Override
	@Transactional
	public void delete(int id) {
		entityManager = entityManagerProvider.get();
		employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			employee.setAddress(null);
			
			entityManager.remove(employee);
		}

	}

	@Transactional
	@Override
	public List<Employee> search(String name) {

		entityManager = entityManagerProvider.get();
		List<Employee> employeeDetailList = new ArrayList<Employee>();
		employeeDetailList = entityManager.createQuery("from Employee e where e.name='" + name + "'").getResultList();
		return employeeDetailList;

	}



	@Transactional
	@Override
	public void update(int id, String name, String contact, String address) {

		entityManager = entityManagerProvider.get();
		Employee employeeobj;
		employeeobj = entityManager.find(Employee.class, id);
		employeeobj.setName(name);

		Phone phoneobj;
		phoneobj = entityManager.find(Phone.class, id);
		phoneobj.setPhone_number(contact);
		employeeobj.getPhone().add(phoneobj);
		phoneobj.setEmployee(employeeobj);

		Address addressobj=new Address();;
		addressobj.setCity(address);
		employeeobj.setAddress(addressobj);	
		entityManager.persist(employeeobj);
		

	}

	@Transactional
	@Override
	public Employee edit(int id) {
		entityManager = entityManagerProvider.get();
		employee = entityManager.find(Employee.class, id);
		System.out.println("inside EditImpl"+employee);
		return employee;
	}

}
