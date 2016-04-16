package com.mobile.app.controller.model.ui;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customerForm")
public class CustomerForm {

	private String name;
	private String empid;
	private String email;
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerForm [name=" + name + ", empid=" + empid + ", email=" + email + ", address=" + address + "]";
	}

}
