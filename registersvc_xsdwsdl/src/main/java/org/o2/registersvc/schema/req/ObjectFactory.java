
package org.o2.registersvc.schema.req;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.o2.registersvc.schema.req package. 
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

    private final static QName _RegisterServiceReq_QNAME = new QName("http://www.o2.org/RegisterSvc/Schema/Req", "RegisterServiceReq");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.o2.registersvc.schema.req
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegisterServiceReqType }
     * 
     */
    public RegisterServiceReqType createRegisterServiceReqType() {
        return new RegisterServiceReqType();
    }

    /**
     * Create an instance of {@link AccountDetailsType }
     * 
     */
    public AccountDetailsType createAccountDetailsType() {
        return new AccountDetailsType();
    }

    /**
     * Create an instance of {@link ServiceDetailsType }
     * 
     */
    public ServiceDetailsType createServiceDetailsType() {
        return new ServiceDetailsType();
    }

    /**
     * Create an instance of {@link CardDetailsType }
     * 
     */
    public CardDetailsType createCardDetailsType() {
        return new CardDetailsType();
    }

    /**
     * Create an instance of {@link ClientDetailsType }
     * 
     */
    public ClientDetailsType createClientDetailsType() {
        return new ClientDetailsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterServiceReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.o2.org/RegisterSvc/Schema/Req", name = "RegisterServiceReq")
    public JAXBElement<RegisterServiceReqType> createRegisterServiceReq(RegisterServiceReqType value) {
        return new JAXBElement<RegisterServiceReqType>(_RegisterServiceReq_QNAME, RegisterServiceReqType.class, null, value);
    }

}
