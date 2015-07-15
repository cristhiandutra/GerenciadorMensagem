package br.com.mensagem.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.mensagem.entidades.Pessoa;

@Local
public interface UsuarioLocal {
	
	List<Pessoa> listar();

	void salvar(Pessoa usuario);

	void excluir(Long idUsuario);

	Pessoa buscar(Long idUsuario);

}
