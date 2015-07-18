package br.com.faeterj.servicomensagensejb.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="ESTADO", schema="mensagem")
@XmlRootElement
@XmlType(propOrder = { 
		"id", 
		"sigla",
		"nome"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String sigla;
	
	private String nome;

	//---------- get's e set's
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="UF")
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String siglaUf) {
		this.sigla = siglaUf;
	}
	
	@Column(name="NOME")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
