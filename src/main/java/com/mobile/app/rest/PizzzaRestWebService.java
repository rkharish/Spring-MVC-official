package com.mobile.app.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.app.controller.model.ui.Dog;
import com.mobile.app.soap.provider.model.Pizza;

@Controller
public class PizzzaRestWebService {
	
	private Map<String, Dog> dataStore=new HashMap<>();
	
	public PizzzaRestWebService(){
		Dog dog1=new Dog("Pomo","D100","dogc@gmail.com","german shephard","This dog is really big","D100.jpg");
		Dog dog2=new Dog("Tomo","D200","togc@gmail.com","Pomolian","This is dangerous ","D200.jpg");
		Dog dog3=new Dog("Somo","D300","sogc@gmail.com","Desi","friendly","D300.jpg");
		Dog dog4=new Dog("Komo","D400","kogc@gmail.com","Tsjshs","not friendly","D400.jpg");
		dataStore.put("dogc@gmail.com", dog1);
		dataStore.put("togc@gmail.com", dog2);
		dataStore.put("sogc@gmail.com", dog3);
		dataStore.put("kogc@gmail.com", dog4);
	}
	
	@RequestMapping(value="/validateDog",method=RequestMethod.GET)
	@ResponseBody public Dog findDogDetail(@RequestParam("email") String email){
			Dog dog=dataStore.get(email);
			return dog;
	}
	
	
//http://localhost:8080/spring-app-mobile/mobile/pizzaDetail
//	/@ResponseBody ->> it converts your object into JSON/xml response
	@RequestMapping(value="/pizzaDetail",method=RequestMethod.GET)
	@ResponseBody public Pizza findPizzaDetail(){
		Pizza pizza=new Pizza();
		pizza.setPrice(12.2F);
		pizza.setSize("Medium");
		pizza.setStore("Ghaziabad");
		pizza.setType("Veg");
		//
		return pizza; //here we are returning java object
	}

}
