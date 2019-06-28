package com.axelor.restdemo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int phone_id;
	
	private  String phone_number;
	
	@ManyToOne(cascade=CascadeType.ALL)  
	@JoinColumn(name="id")
	private Employee employee;
	
	public Phone(){}

	public Phone(Employee employee,String phone_number) {
		super();
		this.employee=employee;
		this.phone_number = phone_number;
	
	}



	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	public int getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "Phone [phone_id=" + phone_id + ", phone_number=" + phone_number + "]";
	}

	

	
	

	
	
}
