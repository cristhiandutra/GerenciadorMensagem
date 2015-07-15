package br.com.mensagem.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mensagem.ejb.interfaces.UsuarioLocal;
import br.com.mensagem.entidades.Pessoa;
import br.com.mensagem.vo.UsuarioVO;

@ViewScoped
@ManagedBean
public class UsuarioMB extends GenericoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private UsuarioLocal usuarioBean;
	
	private Pessoa usuario = new Pessoa();
	private List<Pessoa> usuarios;
	
	public void configurar() {
		usuarios = usuarioBean.listar();
	}

	public String salvar() {
		usuarioBean.salvar(usuario);
		
		return "lista?faces-redirect=true";
	}
	
	public String excluir(Long idUsuario) {
		usuarioBean.excluir(idUsuario);
		
		return "lista?faces-redirect=true";
	}
	
	public String alterar(Long idUsuario) {
	    usuario = usuarioBean.buscar(idUsuario);
		
		return "formulario?faces-redirect=true";
	}

	public Pessoa getUsuario() {
		return usuario;
	}

	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}

	public List<Pessoa> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Pessoa> usuarios) {
		this.usuarios = usuarios;
	}
}
