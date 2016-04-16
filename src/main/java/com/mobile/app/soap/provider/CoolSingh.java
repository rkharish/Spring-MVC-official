package com.mobile.app.soap.provider;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@ SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL,parameterStyle=ParameterStyle.WRAPPED)
public class CoolSingh {
	
	public String pool(String pname,String email) {
		  return "_______________cool!!!!!!!!!!!!!!___________";
	}

}
