package br.com.mensagem.manageBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mensagem.ejb.interfaces.HelloLocal;

@ManagedBean
@ViewScoped
public class HelloMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private HelloLocal helloBean;
	
	private String nome;
	
	public String recuperarNome(){
		nome = helloBean.recuperarNome();
		return "welcome";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
