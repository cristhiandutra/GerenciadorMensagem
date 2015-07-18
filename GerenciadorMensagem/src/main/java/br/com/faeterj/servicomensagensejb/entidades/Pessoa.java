package br.com.faeterj.servicomensagensejb.entidades;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="PESSOA", schema="mensagem")
@XmlRootElement
@XmlType(propOrder = { 
		"id", 
		"nome",
		"sobrenome",
		"cpf",
		"login",
		"senha",
		"email",
		"dataNascimento",
		"perfil",
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	private Long cpf;
	
	private String login;
	
	private String senha;
	
	private String email;
	
	private Calendar dataNascimento;
	
	private Perfil perfil;
	
	private Boolean indAtivo;
	
	//----------- get's e set's
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NOME")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="SOBRENOME")
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Column(name="CPF")
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	@Column(name="LOGIN")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name="SENHA")
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="DATA_NASCIMENTO")
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNasci) {
		this.dataNascimento = dataNasci;
	}

	@ManyToOne
	@JoinColumn(name="PERFIL_ID")
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	@Column(name="IND_ATIVO", columnDefinition = "BIT", length = 1)
	public Boolean getIndAtivo() {
		return indAtivo;
	}
	public void setIndAtivo(Boolean indAtivo) {
		this.indAtivo = indAtivo;
	}
	
}
