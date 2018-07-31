
package org.o2.registersvc.schema.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for serviceDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apiName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceDetailsType", propOrder = {
    "serviceNum",
    "apiName",
    "version"
})
public class ServiceDetailsType {

    @XmlElement(required = true)
    protected String serviceNum;
    @XmlElement(required = true)
    protected String apiName;
    @XmlElement(required = true)
    protected String version;

    /**
     * Gets the value of the serviceNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceNum() {
        return serviceNum;
    }

    /**
     * Sets the value of the serviceNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceNum(String value) {
        this.serviceNum = value;
    }

    /**
     * Gets the value of the apiName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiName() {
        return apiName;
    }

    /**
     * Sets the value of the apiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiName(String value) {
        this.apiName = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
