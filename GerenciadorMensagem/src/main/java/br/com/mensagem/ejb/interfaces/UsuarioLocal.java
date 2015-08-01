package br.com.mensagem.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.faeterj.servicomensagensejb.entidades.Pessoa;




@Local
public interface UsuarioLocal {
	
	List<Pessoa> listar();
	void salvar(Pessoa usuario);
	Pessoa buscar(Long idUsuario);
}
