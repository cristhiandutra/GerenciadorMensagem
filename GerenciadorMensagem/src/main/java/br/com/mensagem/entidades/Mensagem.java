package br.com.mensagem.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="MENSAGEM", schema="mydb")
@XmlRootElement
@XmlType(propOrder = { 
		"id", 
		"titulo",
		"conteudo",
		"indAtivo"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;
		
	private Long id;
	
	private String titulo;
	
	private String conteudo;

	private Boolean indAtivo;
	
	//--------- get's e set's
	
	@Id
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="TITULO")
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Column(name="TEXTO")
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="IND_ATIVO")
	public Boolean getIndAtivo() {
		return indAtivo;
	}
	public void setIndAtivo(Boolean indAtivo) {
		this.indAtivo = indAtivo;
	}
	
}
