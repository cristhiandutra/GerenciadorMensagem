package br.com.mensagem.ejb.implementacao;

import javax.ejb.Stateless;

import br.com.mensagem.ejb.interfaces.HelloLocal;

@Stateless
public class HelloBean implements HelloLocal{

	@Override
	public String recuperarNome() {
		return "Cristhian";
	}

}
