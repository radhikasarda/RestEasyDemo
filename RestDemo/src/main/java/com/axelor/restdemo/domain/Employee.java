package com.axelor.restdemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL ,orphanRemoval = true,fetch = FetchType.EAGER)
	//@JoinTable(name = "EMPLOYEE_PHONE", joinColumns = { @JoinColumn(name = "EMPLOYEE_ID") }, inverseJoinColumns = { @JoinColumn(name = "PHONE_ID") })
	private List<Phone> phone=new ArrayList<Phone>();
	

	@ManyToOne(cascade = CascadeType.ALL )
	@JoinColumn(name="address_id")
	private Address address;
	

	public Employee(){}

	public Employee( String name, List<Phone> phone, Address address) {
		
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

  public Address getAddress() {
  return address;}

  public void setAddress(Address address) {
  this.address = address;}

  @Override
  public String toString() {
    return "Employee [id="
        + id
        + ", name="
        + name
        + ", phone="
        + phone
        + ", address="
        + address
        + "]";
  }
	



	
	
}
