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
import br.com.mensagem.servicoMensagemWS.ManterPessoaWS;
import br.com.mensagem.servicoMensagemWS.ManterPessoaWS_Service;

@Stateless
public class UsuarioBean implements UsuarioLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
    static ManterPessoaWS_Service servico;

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
	
//	@Override
//	public void salvar(Pessoa usuario) {
//		try {
//			ManterPessoaWS_Service servico = new ManterPessoaWS_Service();
//			ManterPessoaWS manterPessoaWS = servico.getManterPessoaPort();
//			manterPessoaWS.cadastrarPessoa(usuario);
//			
//			if (null != usuario.getId()) {
//				manterPessoaWS.alterarPessoa(usuario);
//			} else {
//				manterPessoaWS.cadastrarPessoa(usuario);
//			}
//			
//		} catch (ManterPessoaFaultException e) {
//			e.printStackTrace();
//		} 
//	}
//
//	@Override
//	public List<Pessoa> listar() {
//		List<Pessoa> lista = null; 
//		
//		try {
//			ManterPessoaWS_Service servico = new ManterPessoaWS_Service();
//			ManterPessoaWS manterPessoaWS = servico.getManterPessoaPort();
//			
//			lista = (List<Pessoa>) manterPessoaWS.listarPessoas();
//			
//		} catch (ManterPessoaFaultException e) {
//			e.printStackTrace();
//		} 
//		
//		return lista;
//	}
//
//	@Override
//	public Pessoa buscar(Long idUsuario) {
//		Pessoa pessoa = null;
//		
//		try {
//			ManterPessoaWS_Service servico = new ManterPessoaWS_Service();
//			ManterPessoaWS manterPessoaWS = servico.getManterPessoaPort();
//			
//			pessoa = manterPessoaWS.buscarPessoas(idUsuario);
//			
//		} catch (ManterPessoaFaultException e) {
//			e.printStackTrace();
//		}
//		
//		return pessoa;
//	}
}
