package com.mobile.app.controller;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobile.app.controller.model.ui.Address;
import com.mobile.app.controller.model.ui.CustomerForm;
import com.mobile.app.controller.model.ui.MessageResponse;
import com.mobile.app.controller.model.ui.Phone;

@Controller  ///@Component,@Repository,@Service
public class CustomerController {

	@RequestMapping(value = "customerProfile", method = RequestMethod.GET)
	public String customerPage(Model model) {
		///////////////////////////////////////
		Phone phone=new Phone();
		phone.setMobile1("0987226622");
		phone.setMobile2("09891223883");
		////////////////////////////
		Address address=new Address();
		address.setCity("Ghaziabad");
		address.setPhone(phone);
		address.setPincode("232121");
		address.setState("UP");
		address.setStreet("H-282,Oyeye7222");
		CustomerForm customerForm=new CustomerForm();
		customerForm.setAddress(address);
		customerForm.setEmail("nagen@gmail.com");
		customerForm.setEmpid("40171818");
		customerForm.setName("Nagendra Kumar");
		model.addAttribute("ccustomer", customerForm);
		/////////////////////////////////////////////
		
		
		return "customerProfile";
	}
	
	@RequestMapping(value = "customerProfile", method = RequestMethod.POST)
	public String customerProfilePost(@ModelAttribute("ccustomer") CustomerForm customerForm) {
		System.out.println(customerForm);
		return "customerProfile";
	}
	
	
	@RequestMapping(value = "acustomerProfile", method = RequestMethod.GET)
	public String acustomerPage(Model model) {
		///////////////////////////////////////
		Phone phone=new Phone();
		phone.setMobile1("0987226622");
		phone.setMobile2("09891223883");
		////////////////////////////
		Address address=new Address();
		address.setCity("Ghaziabad");
		address.setPhone(phone);
		address.setPincode("232121");
		address.setState("UP");
		address.setStreet("H-282,Oyeye7222");
		CustomerForm customerForm=new CustomerForm();
		customerForm.setAddress(address);
		customerForm.setEmail("nagen@gmail.com");
		customerForm.setEmpid("40171818");
		customerForm.setName("Nagendra Kumar");
		model.addAttribute("ccustomer", customerForm);
		/////////////////////////////////////////////
		return "customerProfile";
	}
	
	@RequestMapping(value = "acustomerProfile", method = RequestMethod.POST)
	public @ResponseBody MessageResponse acustomerProfilePost(@ModelAttribute("ccustomer") CustomerForm customerForm) {
		System.out.println(customerForm);
		 try {
	            JAXBContext context = JAXBContext.newInstance(CustomerForm.class);
	            Marshaller marshaller = context.createMarshaller();
	            //for pretty-print XML in JAXB
	            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	            // Write to System.out for debugging
	            marshaller.marshal(customerForm, System.out);
	            StringWriter stringWriter = new StringWriter();
	            marshaller.marshal(customerForm,stringWriter);
	            String xml = stringWriter.toString();
	            System.out.println("alalla- - = "+xml);
	            // Write to File
	          //  m.marshal(emp, new File(FILE_NAME));
	        } catch (JAXBException e) {
	            e.printStackTrace();
	        }
		MessageResponse messageResponse=new MessageResponse();
		messageResponse.setStatus("M2100");
		messageResponse.setMessage("success");
		messageResponse.setDescription("Yeap done!");
		return messageResponse;
	}

}
