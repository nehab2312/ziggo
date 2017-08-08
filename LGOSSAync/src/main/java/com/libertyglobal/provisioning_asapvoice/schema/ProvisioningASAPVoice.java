
package com.libertyglobal.provisioning_asapvoice.schema;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="serviceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="requestType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="originator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="affiliate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="tradingPartner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="instance" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="parameters">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "header",
    "parameters"
})
@XmlRootElement(name = "provisioning_ASAPVoice")
public class ProvisioningASAPVoice {

    @XmlElement(required = true)
    protected ProvisioningASAPVoice.Header header;
    @XmlElement(required = true)
    protected ProvisioningASAPVoice.Parameters parameters;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link ProvisioningASAPVoice.Header }
     *     
     */
    public ProvisioningASAPVoice.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProvisioningASAPVoice.Header }
     *     
     */
    public void setHeader(ProvisioningASAPVoice.Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link ProvisioningASAPVoice.Parameters }
     *     
     */
    public ProvisioningASAPVoice.Parameters getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProvisioningASAPVoice.Parameters }
     *     
     */
    public void setParameters(ProvisioningASAPVoice.Parameters value) {
        this.parameters = value;
    }


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
     *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="serviceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="requestType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="originator" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="affiliate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="tradingPartner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="instance" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "requestId",
        "serviceType",
        "requestType",
        "originator",
        "affiliate",
        "tradingPartner",
        "countryCode",
        "instance"
    })
    public static class Header {

        @XmlElement(required = true)
        protected String requestId;
        @XmlElement(required = true)
        protected String serviceType;
        @XmlElement(required = true)
        protected String requestType;
        @XmlElement(required = true)
        protected String originator;
        @XmlElement(required = true)
        protected String affiliate;
        protected String tradingPartner;
        @XmlElement(required = true)
        protected String countryCode;
        @XmlElement(required = true)
        protected String instance;

        /**
         * Gets the value of the requestId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequestId() {
            return requestId;
        }

        /**
         * Sets the value of the requestId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequestId(String value) {
            this.requestId = value;
        }

        /**
         * Gets the value of the serviceType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceType() {
            return serviceType;
        }

        /**
         * Sets the value of the serviceType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceType(String value) {
            this.serviceType = value;
        }

        /**
         * Gets the value of the requestType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequestType() {
            return requestType;
        }

        /**
         * Sets the value of the requestType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequestType(String value) {
            this.requestType = value;
        }

        /**
         * Gets the value of the originator property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOriginator() {
            return originator;
        }

        /**
         * Sets the value of the originator property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOriginator(String value) {
            this.originator = value;
        }

        /**
         * Gets the value of the affiliate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAffiliate() {
            return affiliate;
        }

        /**
         * Sets the value of the affiliate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAffiliate(String value) {
            this.affiliate = value;
        }

        /**
         * Gets the value of the tradingPartner property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTradingPartner() {
            return tradingPartner;
        }

        /**
         * Sets the value of the tradingPartner property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTradingPartner(String value) {
            this.tradingPartner = value;
        }

        /**
         * Gets the value of the countryCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountryCode() {
            return countryCode;
        }

        /**
         * Sets the value of the countryCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountryCode(String value) {
            this.countryCode = value;
        }

        /**
         * Gets the value of the instance property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInstance() {
            return instance;
        }

        /**
         * Sets the value of the instance property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInstance(String value) {
            this.instance = value;
        }

    }


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
     *         &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "param"
    })
    public static class Parameters {

        protected List<ProvisioningASAPVoice.Parameters.Param> param;

        /**
         * Gets the value of the param property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the param property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getParam().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ProvisioningASAPVoice.Parameters.Param }
         * 
         * 
         */
        public List<ProvisioningASAPVoice.Parameters.Param> getParam() {
            if (param == null) {
                param = new ArrayList<ProvisioningASAPVoice.Parameters.Param>();
            }
            return this.param;
        }


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
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "name",
            "value"
        })
        public static class Param {

            @XmlElement(required = true)
            protected String name;
            @XmlElement(required = true)
            protected String value;

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }

}
