package com.mobile.app.soap.provider.fault;

public class PizzaErrorMessage {
	private String message;
	private String mcode;
	private String description;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PizzaErrorMessage [message=" + message + ", mcode=" + mcode + ", description=" + description + "]";
	}

}
