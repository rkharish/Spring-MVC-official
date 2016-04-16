
package com.burger.fresh;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BurgerStoreServiceProvider", targetNamespace = "http://www.burger.com/fresh")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BurgerStoreServiceProvider {


    /**
     * 
     * @param pbugRequest
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://www.burger.com/fresh/uploadBurger")
    @WebResult(name = "burgerResponse", targetNamespace = "http://www.burger.com/fresh", partName = "return")
    public String uploadBurger(
        @WebParam(name = "burgerReqeust", targetNamespace = "http://www.burger.com/fresh", partName = "pbugRequest")
        Burger pbugRequest);

}