
package org.o2.registersvc.schema.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegisterServiceReqType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegisterServiceReqType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientDetails" type="{http://www.o2.org/RegisterSvc/Schema/Req}clientDetailsType"/>
 *         &lt;element name="cardDetails" type="{http://www.o2.org/RegisterSvc/Schema/Req}cardDetailsType"/>
 *         &lt;element name="accountDetails" type="{http://www.o2.org/RegisterSvc/Schema/Req}accountDetailsType"/>
 *         &lt;element name="serviceDetails" type="{http://www.o2.org/RegisterSvc/Schema/Req}serviceDetailsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisterServiceReqType", propOrder = {
    "clientDetails",
    "cardDetails",
    "accountDetails",
    "serviceDetails"
})
public class RegisterServiceReqType {

    @XmlElement(required = true)
    protected ClientDetailsType clientDetails;
    @XmlElement(required = true)
    protected CardDetailsType cardDetails;
    @XmlElement(required = true)
    protected AccountDetailsType accountDetails;
    @XmlElement(required = true)
    protected ServiceDetailsType serviceDetails;

    /**
     * Gets the value of the clientDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ClientDetailsType }
     *     
     */
    public ClientDetailsType getClientDetails() {
        return clientDetails;
    }

    /**
     * Sets the value of the clientDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientDetailsType }
     *     
     */
    public void setClientDetails(ClientDetailsType value) {
        this.clientDetails = value;
    }

    /**
     * Gets the value of the cardDetails property.
     * 
     * @return
     *     possible object is
     *     {@link CardDetailsType }
     *     
     */
    public CardDetailsType getCardDetails() {
        return cardDetails;
    }

    /**
     * Sets the value of the cardDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardDetailsType }
     *     
     */
    public void setCardDetails(CardDetailsType value) {
        this.cardDetails = value;
    }

    /**
     * Gets the value of the accountDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AccountDetailsType }
     *     
     */
    public AccountDetailsType getAccountDetails() {
        return accountDetails;
    }

    /**
     * Sets the value of the accountDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountDetailsType }
     *     
     */
    public void setAccountDetails(AccountDetailsType value) {
        this.accountDetails = value;
    }

    /**
     * Gets the value of the serviceDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDetailsType }
     *     
     */
    public ServiceDetailsType getServiceDetails() {
        return serviceDetails;
    }

    /**
     * Sets the value of the serviceDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDetailsType }
     *     
     */
    public void setServiceDetails(ServiceDetailsType value) {
        this.serviceDetails = value;
    }

}
