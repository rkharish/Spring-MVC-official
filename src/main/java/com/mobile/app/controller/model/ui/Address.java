package com.mobile.app.controller.model.ui;

public class Address {

	private String city;
	private String state;
	private String street;
	private String pincode;
	private Phone phone;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", street=" + street + ", pincode=" + pincode + ", phone="
				+ phone + "]";
	}

}
