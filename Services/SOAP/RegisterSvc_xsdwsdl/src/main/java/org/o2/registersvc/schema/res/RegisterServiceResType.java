
package org.o2.registersvc.schema.res;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegisterServiceResType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegisterServiceResType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusBlock" type="{http://www.o2.org/RegisterSvc/Schema/Res}statusBlockType"/>
 *         &lt;element name="creditCheck" type="{http://www.o2.org/RegisterSvc/Schema/Res}creditCheckType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisterServiceResType", propOrder = {
    "statusBlock",
    "creditCheck"
})
public class RegisterServiceResType {

    @XmlElement(required = true)
    protected StatusBlockType statusBlock;
    @XmlElement(required = true)
    protected CreditCheckType creditCheck;

    /**
     * Gets the value of the statusBlock property.
     * 
     * @return
     *     possible object is
     *     {@link StatusBlockType }
     *     
     */
    public StatusBlockType getStatusBlock() {
        return statusBlock;
    }

    /**
     * Sets the value of the statusBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusBlockType }
     *     
     */
    public void setStatusBlock(StatusBlockType value) {
        this.statusBlock = value;
    }

    /**
     * Gets the value of the creditCheck property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCheckType }
     *     
     */
    public CreditCheckType getCreditCheck() {
        return creditCheck;
    }

    /**
     * Sets the value of the creditCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCheckType }
     *     
     */
    public void setCreditCheck(CreditCheckType value) {
        this.creditCheck = value;
    }

}
