package br.com.mensagem.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.faeterj.servicomensagensejb.entidades.Perfil;
import br.com.faeterj.servicomensagensejb.entidades.Pessoa;
import br.com.mensagem.ejb.interfaces.PerfilLocal;
import br.com.mensagem.ejb.interfaces.UsuarioLocal;

@ViewScoped
@ManagedBean
public class UsuarioMB extends GenericoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private UsuarioLocal usuarioBean;
	
	@EJB
	private PerfilLocal perfilBean;
	
	// Atributos usados no formuario
	private Pessoa usuario = new Pessoa();
	private List<Perfil> perfis = new ArrayList<Perfil>();
	private Long idPerfil;
	
	// Atributos usados na lista
	private List<Pessoa> usuarios;
	
	public void configurarLista() {
		usuarios = usuarioBean.listar();
	}
	
	public void configurarFormulario() {
		try {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) context.getRequest();
			String idUsuario = request.getParameter("idUsuario");
			
			if (null != idUsuario && !"".equals(idUsuario)) {
				usuario = usuarioBean.buscar(new Long(idUsuario));
				idPerfil = usuario.getPerfil().getId();
			}
			
			perfis = perfilBean.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String salvar() {
		Perfil perfil = perfilBean.buscarPorId(idPerfil);
		usuario.setPerfil(perfil);
		usuarioBean.salvar(usuario);
		
		return "lista?faces-redirect=true";
	}
	
	public String excluir(Long idUsuario) {
		usuarioBean.excluir(idUsuario);
		
		return "lista?faces-redirect=true";
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

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
}
