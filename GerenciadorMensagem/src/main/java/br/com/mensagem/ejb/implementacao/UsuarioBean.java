package br.com.mensagem.ejb.implementacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.faeterj.servicomensagensejb.dao.interfaces.PessoaDAO;
import br.com.faeterj.servicomensagensejb.daofabrica.excecoes.ExcecaoGenerica;
import br.com.faeterj.servicomensagensejb.daofabrica.fabrica.DAOFabricaImpl;
import br.com.faeterj.servicomensagensejb.entidades.Pessoa;
import br.com.mensagem.ejb.interfaces.UsuarioLocal;

@Stateless
public class UsuarioBean implements UsuarioLocal {
	
	@PersistenceContext
	private EntityManager entityManager;

	public PessoaDAO getPessoaDAO() throws ExcecaoGenerica {
		return (PessoaDAO) new DAOFabricaImpl(entityManager).getDAO(Pessoa.class);
	}

	@Override
	public List<Pessoa> listar() {
		List<Pessoa> lista = null;
		
		try {
			lista = getPessoaDAO().listarAscOuDesc("id", true);
		} catch (ExcecaoGenerica e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public void salvar(Pessoa usuario) {
		try {
			if (null != usuario.getId()) {
				getPessoaDAO().alterar(usuario);
			} else {
				getPessoaDAO().salvar(usuario);
			}
			
		} catch (ExcecaoGenerica e) {
			e.printStackTrace();
		}
	}

	@Override
	public Pessoa buscar(Long idUsuario) {
		Pessoa pessoa = null;
		
		try {
			pessoa = getPessoaDAO().buscarPorId(idUsuario);
		} catch (ExcecaoGenerica e) {
			e.printStackTrace();
		}
		
		return pessoa;
	}

}
