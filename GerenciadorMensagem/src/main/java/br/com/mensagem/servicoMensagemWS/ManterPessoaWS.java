
package br.com.mensagem.servicoMensagemWS;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "manterPessoaWS", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ManterPessoaWS {


    /**
     * 
     * @param pessoa
     * @return
     *     returns br.com.faeterj.servicomensagens.manterpessoaws.Pessoa
     * @throws ManterPessoaFaultException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cadastrarPessoa", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", className = "br.com.faeterj.servicomensagens.manterpessoaws.CadastrarPessoa")
    @ResponseWrapper(localName = "cadastrarPessoaResponse", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", className = "br.com.faeterj.servicomensagens.manterpessoaws.CadastrarPessoaResponse")
    public Pessoa cadastrarPessoa(
        @WebParam(name = "pessoa", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws")
        Pessoa pessoa)
        throws ManterPessoaFaultException
    ;

    /**
     * 
     * @return
     *     returns br.com.faeterj.servicomensagens.manterpessoaws.ListaPessoaWrapper
     * @throws ManterPessoaFaultException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarPessoas", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", className = "br.com.faeterj.servicomensagens.manterpessoaws.ListarPessoas")
    @ResponseWrapper(localName = "listarPessoasResponse", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", className = "br.com.faeterj.servicomensagens.manterpessoaws.ListarPessoasResponse")
    public ListaPessoaWrapper listarPessoas()
        throws ManterPessoaFaultException
    ;

    /**
     * 
     * @param idPessoa
     * @return
     *     returns br.com.faeterj.servicomensagens.manterpessoaws.Pessoa
     * @throws ManterPessoaFaultException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarPessoas", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", className = "br.com.faeterj.servicomensagens.manterpessoaws.BuscarPessoas")
    @ResponseWrapper(localName = "buscarPessoasResponse", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", className = "br.com.faeterj.servicomensagens.manterpessoaws.BuscarPessoasResponse")
    public Pessoa buscarPessoas(
        @WebParam(name = "idPessoa", targetNamespace = "")
        Long idPessoa)
        throws ManterPessoaFaultException
    ;

    /**
     * 
     * @param pessoa
     * @throws ManterPessoaFaultException
     */
    @WebMethod
    @RequestWrapper(localName = "alterarPessoa", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", className = "br.com.faeterj.servicomensagens.manterpessoaws.AlterarPessoa")
    @ResponseWrapper(localName = "alterarPessoaResponse", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws", className = "br.com.faeterj.servicomensagens.manterpessoaws.AlterarPessoaResponse")
    public void alterarPessoa(
        @WebParam(name = "pessoa", targetNamespace = "http://servicomensagens.faeterj.com.br/manterpessoaws")
        Pessoa pessoa)
        throws ManterPessoaFaultException
    ;

}
