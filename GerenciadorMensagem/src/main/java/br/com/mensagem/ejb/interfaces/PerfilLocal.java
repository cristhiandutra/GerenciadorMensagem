package br.com.mensagem.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.faeterj.servicomensagensejb.entidades.Perfil;

@Local
public interface PerfilLocal {
	
	List<Perfil> listar();
	Perfil buscarPorId(Long id);
}
