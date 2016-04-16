
package com.burger.fresh;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.burger.fresh package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BurgerResponse_QNAME = new QName("http://www.burger.com/fresh", "burgerResponse");
    private final static QName _BurgerReqeust_QNAME = new QName("http://www.burger.com/fresh", "burgerReqeust");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.burger.fresh
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Burger }
     * 
     */
    public Burger createBurger() {
        return new Burger();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.burger.com/fresh", name = "burgerResponse")
    public JAXBElement<String> createBurgerResponse(String value) {
        return new JAXBElement<String>(_BurgerResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Burger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.burger.com/fresh", name = "burgerReqeust")
    public JAXBElement<Burger> createBurgerReqeust(Burger value) {
        return new JAXBElement<Burger>(_BurgerReqeust_QNAME, Burger.class, null, value);
    }

}
