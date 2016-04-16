package com.burger.fresh.provider;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.burger.fresh.Burger;
import com.burger.fresh.BurgerStoreServiceProvider;

@WebService(name = "BurgerStoreServiceProvider", serviceName = "BurgerStoreServiceProviderService", 
portName = "BurgerStoreServiceProviderPort", endpointInterface = "com.burger.fresh.BurgerStoreServiceProvider",
targetNamespace = "http://www.burger.com/fresh", wsdlLocation = "/wsdl/burger.wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class BurgerStoreServiceProviderImpl implements BurgerStoreServiceProvider {

	@Override
	public String uploadBurger(Burger pbugRequest) {
			System.out.println("pbugRequest = "+pbugRequest.getPrice());
			System.out.println("pbugRequest = "+pbugRequest.getStore());
			System.out.println("pbugRequest = "+pbugRequest.getVendor());
			return "Hey your burger is uploade into cool store";
	}

}
