package com.mobile.app.soap.provider.fault;

public class PizzaOrderNotValidException  extends Exception {
	
	private PizzaErrorMessage errorMessage;

	/**
	 * 
	 * @param message ->>Normal message
	 * @param errorMessage  ->>Detail message
	 */
	public PizzaOrderNotValidException(String message,  PizzaErrorMessage errorMessage) {
		super(message);
		this.errorMessage = errorMessage;
	}
	
	public PizzaErrorMessage getFault(){
		return errorMessage;
	}

	@Override
	public String toString() {
		return "PizzaOrderNotValidException [errorMessage=" + errorMessage + "]";
	}

}
