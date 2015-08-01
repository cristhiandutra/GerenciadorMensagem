
package br.com.mensagem.servicoMensagemWS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.faeterj.servicomensagens.manterpessoaws package. 
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

    private final static QName _AlterarPessoa_QNAME = new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "alterarPessoa");
    private final static QName _ListarPessoas_QNAME = new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "listarPessoas");
    private final static QName _BuscarPessoasResponse_QNAME = new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "buscarPessoasResponse");
    private final static QName _CadastrarPessoaResponse_QNAME = new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "cadastrarPessoaResponse");
    private final static QName _ListarPessoasResponse_QNAME = new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "listarPessoasResponse");
    private final static QName _CadastrarPessoa_QNAME = new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "cadastrarPessoa");
    private final static QName _ManterPessoaFault_QNAME = new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "ManterPessoaFault");
    private final static QName _AlterarPessoaResponse_QNAME = new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "alterarPessoaResponse");
    private final static QName _Perfil_QNAME = new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "perfil");
    private final static QName _Pessoa_QNAME = new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "pessoa");
    private final static QName _BuscarPessoas_QNAME = new QName("http://servicomensagens.faeterj.com.br/manterpessoaws", "buscarPessoas");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.faeterj.servicomensagens.manterpessoaws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarPessoasResponse }
     * 
     */
    public ListarPessoasResponse createListarPessoasResponse() {
        return new ListarPessoasResponse();
    }

    /**
     * Create an instance of {@link ListarPessoas }
     * 
     */
    public ListarPessoas createListarPessoas() {
        return new ListarPessoas();
    }

    /**
     * Create an instance of {@link AlterarPessoa }
     * 
     */
    public AlterarPessoa createAlterarPessoa() {
        return new AlterarPessoa();
    }

    /**
     * Create an instance of {@link ListaPessoaWrapper }
     * 
     */
    public ListaPessoaWrapper createListaPessoaWrapper() {
        return new ListaPessoaWrapper();
    }

    /**
     * Create an instance of {@link ManterPessoaFaultMessage }
     * 
     */
    public ManterPessoaFaultMessage createManterPessoaFaultMessage() {
        return new ManterPessoaFaultMessage();
    }

    /**
     * Create an instance of {@link Pessoa }
     * 
     */
    public Pessoa createPessoa() {
        return new Pessoa();
    }

    /**
     * Create an instance of {@link BuscarPessoasResponse }
     * 
     */
    public BuscarPessoasResponse createBuscarPessoasResponse() {
        return new BuscarPessoasResponse();
    }

    /**
     * Create an instance of {@link Perfil }
     * 
     */
    public Perfil createPerfil() {
        return new Perfil();
    }

    /**
     * Create an instance of {@link ManterPessoaFault }
     * 
     */
    public ManterPessoaFault createManterPessoaFault() {
        return new ManterPessoaFault();
    }

    /**
     * Create an instance of {@link CadastrarPessoa }
     * 
     */
    public CadastrarPessoa createCadastrarPessoa() {
        return new CadastrarPessoa();
    }

    /**
     * Create an instance of {@link AlterarPessoaResponse }
     * 
     */
    public AlterarPessoaResponse createAlterarPessoaResponse() {
        return new AlterarPessoaResponse();
    }

    /**
     * Create an instance of {@link BuscarPessoas }
     * 
     */
    public BuscarPessoas createBuscarPessoas() {
        return new BuscarPessoas();
    }

    /**
     * Create an instance of {@link CadastrarPessoaResponse }
     * 
     */
    public CadastrarPessoaResponse createCadastrarPessoaResponse() {
        return new CadastrarPessoaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AlterarPessoa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", name = "alterarPessoa")
    public JAXBElement<AlterarPessoa> createAlterarPessoa(AlterarPessoa value) {
        return new JAXBElement<AlterarPessoa>(_AlterarPessoa_QNAME, AlterarPessoa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPessoas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", name = "listarPessoas")
    public JAXBElement<ListarPessoas> createListarPessoas(ListarPessoas value) {
        return new JAXBElement<ListarPessoas>(_ListarPessoas_QNAME, ListarPessoas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarPessoasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", name = "buscarPessoasResponse")
    public JAXBElement<BuscarPessoasResponse> createBuscarPessoasResponse(BuscarPessoasResponse value) {
        return new JAXBElement<BuscarPessoasResponse>(_BuscarPessoasResponse_QNAME, BuscarPessoasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarPessoaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", name = "cadastrarPessoaResponse")
    public JAXBElement<CadastrarPessoaResponse> createCadastrarPessoaResponse(CadastrarPessoaResponse value) {
        return new JAXBElement<CadastrarPessoaResponse>(_CadastrarPessoaResponse_QNAME, CadastrarPessoaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPessoasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", name = "listarPessoasResponse")
    public JAXBElement<ListarPessoasResponse> createListarPessoasResponse(ListarPessoasResponse value) {
        return new JAXBElement<ListarPessoasResponse>(_ListarPessoasResponse_QNAME, ListarPessoasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarPessoa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", name = "cadastrarPessoa")
    public JAXBElement<CadastrarPessoa> createCadastrarPessoa(CadastrarPessoa value) {
        return new JAXBElement<CadastrarPessoa>(_CadastrarPessoa_QNAME, CadastrarPessoa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManterPessoaFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", name = "ManterPessoaFault")
    public JAXBElement<ManterPessoaFault> createManterPessoaFault(ManterPessoaFault value) {
        return new JAXBElement<ManterPessoaFault>(_ManterPessoaFault_QNAME, ManterPessoaFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AlterarPessoaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", name = "alterarPessoaResponse")
    public JAXBElement<AlterarPessoaResponse> createAlterarPessoaResponse(AlterarPessoaResponse value) {
        return new JAXBElement<AlterarPessoaResponse>(_AlterarPessoaResponse_QNAME, AlterarPessoaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Perfil }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", name = "perfil")
    public JAXBElement<Perfil> createPerfil(Perfil value) {
        return new JAXBElement<Perfil>(_Perfil_QNAME, Perfil.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pessoa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", name = "pessoa")
    public JAXBElement<Pessoa> createPessoa(Pessoa value) {
        return new JAXBElement<Pessoa>(_Pessoa_QNAME, Pessoa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarPessoas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", name = "buscarPessoas")
    public JAXBElement<BuscarPessoas> createBuscarPessoas(BuscarPessoas value) {
        return new JAXBElement<BuscarPessoas>(_BuscarPessoas_QNAME, BuscarPessoas.class, null, value);
    }

}
