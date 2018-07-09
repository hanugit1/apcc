
package org.o2.registersvc.schema.res;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for creditCheckType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="creditCheckType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rateOfPer" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="creditStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditCheckType", propOrder = {
    "rateOfPer",
    "creditStatus"
})
public class CreditCheckType {

    protected float rateOfPer;
    @XmlElement(required = true)
    protected String creditStatus;

    /**
     * Gets the value of the rateOfPer property.
     * 
     */
    public float getRateOfPer() {
        return rateOfPer;
    }

    /**
     * Sets the value of the rateOfPer property.
     * 
     */
    public void setRateOfPer(float value) {
        this.rateOfPer = value;
    }

    /**
     * Gets the value of the creditStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditStatus() {
        return creditStatus;
    }

    /**
     * Sets the value of the creditStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditStatus(String value) {
        this.creditStatus = value;
    }

}
