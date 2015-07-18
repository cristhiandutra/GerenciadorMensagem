package br.com.faeterj.servicomensagensejb.entidades;

import java.io.Serializable;

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
@Table(name="TELEFONE", schema="mensagem")
@XmlRootElement
@XmlType(propOrder = { 
		"id", 
		"numero",
		"ddd",
		"operadora",
		"pessoa"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Telefone implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Integer numero;
	
	private Integer ddd;
	
	private Operadora operadora;

	private Pessoa pessoa;

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

	@Column(name="NUMERO")
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Column(name="DDD")
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	@ManyToOne
	@JoinColumn(name="OPERADORA_ID")
	public Operadora getOperadora() {
		return operadora;
	}
	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	@ManyToOne
	@JoinColumn(name="PESSOA_ID")
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
