package br.com.mensagem.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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
		if (validar()) {
			return "";
		}
		
		Perfil perfil = perfilBean.buscarPorId(idPerfil);
		usuario.setPerfil(perfil);
		usuarioBean.salvar(usuario);
		
		return "lista?faces-redirect=true";
	}

	private Boolean validar() {
		Boolean validacao = false;		
		
		if (null == usuario.getNome() || "".equals(usuario.getNome())) {
			FacesContext.getCurrentInstance().addMessage("formularioUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo "+"Nome"+" obrigatório.", null));
			validacao = true;
		}
		
		if (null == usuario.getDataNascimento()) {
			FacesContext.getCurrentInstance().addMessage("formularioUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo "+"Data Nascimento"+" obrigatório.", null));
			validacao = true;
		}
		
		if (null == usuario.getCpf() || usuario.getCpf() == 0) {
			FacesContext.getCurrentInstance().addMessage("formularioUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo "+"CPF"+" obrigatório.", null));
			validacao = true;
		}
		
		if (null == usuario.getLogin() || "".equals(usuario.getLogin())) {
			FacesContext.getCurrentInstance().addMessage("formularioUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo "+"Login"+" obrigatório.", null));
			validacao = true;
		}
		
		if (null == usuario.getSenha() || "".equals(usuario.getSenha())) {
			FacesContext.getCurrentInstance().addMessage("formularioUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo "+"Senha"+" obrigatório.", null));
			validacao = true;
		}
		
		if (null == usuario.getEmail() || "".equals(usuario.getEmail())) {
			FacesContext.getCurrentInstance().addMessage("formularioUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo "+"Email"+" obrigatório.", null));
			validacao = true;
		}

		if (null == idPerfil || idPerfil == 0) {
			FacesContext.getCurrentInstance().addMessage("formularioUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo "+"Perfil"+" obrigatório.", null));
			validacao = true;
		}
		
		return validacao;
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
