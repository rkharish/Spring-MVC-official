package com.mobile.app.controller.model.ui;

public class Phone {

	private String mobile1;
	private String mobile2;
	
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	@Override
	public String toString() {
		return "Phone [mobile1=" + mobile1 + ", mobile2=" + mobile2 + "]";
	}
	
}
