
package com.tdcare.bom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iCMDType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "icmdType",
    "iData"
})
@XmlRootElement(name = "DataInterchange")
public class DataInterchange {

    @XmlElement(name = "iCMDType")
    protected String icmdType;
    protected String iData;

    /**
     * Gets the value of the icmdType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICMDType() {
        return icmdType;
    }

    /**
     * Sets the value of the icmdType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICMDType(String value) {
        this.icmdType = value;
    }

    /**
     * Gets the value of the iData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIData() {
        return iData;
    }

    /**
     * Sets the value of the iData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIData(String value) {
        this.iData = value;
    }

}
