
package br.com.mensagem.servicoMensagemWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManterPessoaFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManterPessoaFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pessoaFaultInfo" type="{http://servicomensagens.faeterj.com.br/manterpessoaws}ManterPessoaFaultMessage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManterPessoaFault", propOrder = {
    "pessoaFaultInfo"
})
public class ManterPessoaFault {

    @XmlElement(required = true, nillable = true)
    protected ManterPessoaFaultMessage pessoaFaultInfo;

    /**
     * Gets the value of the pessoaFaultInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ManterPessoaFaultMessage }
     *     
     */
    public ManterPessoaFaultMessage getPessoaFaultInfo() {
        return pessoaFaultInfo;
    }

    /**
     * Sets the value of the pessoaFaultInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManterPessoaFaultMessage }
     *     
     */
    public void setPessoaFaultInfo(ManterPessoaFaultMessage value) {
        this.pessoaFaultInfo = value;
    }

}
