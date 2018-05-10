
package com.tdcare.bom;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tdcare package. 
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

    private final static QName _SValidationSoapHeader_QNAME = new QName("http://www.tdcare.com/", "sValidationSoapHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tdcare
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SValidationSoapHeader }
     * 
     */
    public SValidationSoapHeader createSValidationSoapHeader() {
        return new SValidationSoapHeader();
    }

    /**
     * Create an instance of {@link DataInterchangeResponse }
     * 
     */
    public DataInterchangeResponse createDataInterchangeResponse() {
        return new DataInterchangeResponse();
    }

    /**
     * Create an instance of {@link DataInterchange }
     * 
     */
    public DataInterchange createDataInterchange() {
        return new DataInterchange();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SValidationSoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tdcare.com/", name = "sValidationSoapHeader")
    public JAXBElement<SValidationSoapHeader> createSValidationSoapHeader(SValidationSoapHeader value) {
        return new JAXBElement<SValidationSoapHeader>(_SValidationSoapHeader_QNAME, SValidationSoapHeader.class, null, value);
    }

}
