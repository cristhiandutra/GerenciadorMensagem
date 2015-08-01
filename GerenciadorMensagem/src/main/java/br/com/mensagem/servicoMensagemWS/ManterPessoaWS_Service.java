
package br.com.mensagem.servicoMensagemWS;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "manterPessoaWS", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", wsdlLocation = "http://10.0.1.18:8080/servicomensagensws/manterPessoaWS?wsdl")
public class ManterPessoaWS_Service
    extends Service
{

    private final static URL MANTERPESSOAWS_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ManterPessoaWS_Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = ManterPessoaWS_Service.class.getResource(".");
            url = new URL(baseUrl, "http://10.0.1.18:8080/servicomensagensws/manterPessoaWS?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://10.0.1.18:8080/servicomensagensws/manterPessoaWS?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        MANTERPESSOAWS_WSDL_LOCATION = url;
    }

    public ManterPessoaWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ManterPessoaWS_Service() {
        super(MANTERPESSOAWS_WSDL_LOCATION, new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "manterPessoaWS"));
    }

    /**
     * 
     * @return
     *     returns ManterPessoaWS
     */
    @WebEndpoint(name = "manterPessoaPort")
    public ManterPessoaWS getManterPessoaPort() {
        return super.getPort(new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "manterPessoaPort"), ManterPessoaWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ManterPessoaWS
     */
    @WebEndpoint(name = "manterPessoaPort")
    public ManterPessoaWS getManterPessoaPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "manterPessoaPort"), ManterPessoaWS.class, features);
    }

}