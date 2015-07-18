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
@Table(name="TIPO_FILTRO_GRUPO", schema="mensagem")
@XmlRootElement
@XmlType(propOrder = { 
		"id", 
		"titulo"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class TipoGrupoDestinatarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String titulo;

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

	@Column(name="TITULO")
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
