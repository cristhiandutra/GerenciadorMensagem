package br.com.mensagem.manageBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.mensagem.ejb.interfaces.PerfilLocal;
import br.com.mensagem.ejb.interfaces.UsuarioLocal;
import br.com.mensagem.entidades.Perfil;
import br.com.mensagem.entidades.Pessoa;

@ViewScoped
@ManagedBean
public class UsuarioMB extends GenericoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private UsuarioLocal usuarioBean;
	
	@EJB
	private PerfilLocal perfilBean;
	
	private Pessoa usuario = new Pessoa();
	private List<Pessoa> usuarios;
	private List<Perfil> perfis;
	
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
			}
			
			usuario.setPerfil(new Perfil());
			perfis = perfilBean.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String salvar() {
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

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
}
