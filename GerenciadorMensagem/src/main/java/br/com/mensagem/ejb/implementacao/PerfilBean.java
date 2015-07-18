package br.com.mensagem.ejb.implementacao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.faeterj.servicomensagensejb.dao.interfaces.PerfilDAO;
import br.com.faeterj.servicomensagensejb.daofabrica.excecoes.ExcecaoGenerica;
import br.com.faeterj.servicomensagensejb.daofabrica.fabrica.DAOFabricaImpl;
import br.com.faeterj.servicomensagensejb.entidades.Perfil;
import br.com.mensagem.ejb.interfaces.PerfilLocal;

@Stateless
public class PerfilBean implements PerfilLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public PerfilDAO getPerfilDAO() throws ExcecaoGenerica {
		return (PerfilDAO) new DAOFabricaImpl(entityManager).getDAO(Perfil.class);
	}

	@Override
	public List<Perfil> listar() {
		List<Perfil> lista = null;
		
		try {
			lista = getPerfilDAO().listar();
		} catch (ExcecaoGenerica e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public Perfil buscarPorId(Long id) {
		Perfil perfil = null;
		
		try {
			perfil = getPerfilDAO().buscarPorId(id);
		} catch (ExcecaoGenerica e) {
			e.printStackTrace();
		}
		
		return perfil;
	}


}
