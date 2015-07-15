package br.com.mensagem.ejb.interfaces;

import javax.ejb.Local;

@Local
public interface HelloLocal {

	String recuperarNome();
	
}
