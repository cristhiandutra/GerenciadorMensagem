package br.com.mensagem.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="OPERADORA", schema="mydb")
@XmlRootElement
@XmlType(propOrder = { 
		"id", 
		"nome"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Operadora implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;

	//------- get's e set's
	
	@Id
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
	
}
