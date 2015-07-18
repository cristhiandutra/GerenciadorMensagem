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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import br.com.faeterj.servicomensagensejb.uteis.Uteis;

@Entity
@Table(name="LOG_ENVIO_MENSAGEM", schema="mensagem")
@XmlRootElement
@XmlType(propOrder = { 
		"id", 
		"dataHoraIncl",
		"mensagem",
		"usuario",
		"contato",
		"justificativa"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class LogEnvioMensagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@XmlElement(name="dataHoraIncl")
	@XmlSchemaType(name="dateTime", type=javax.xml.datatype.XMLGregorianCalendar.class)
	private XMLGregorianCalendar dataHoraIncl;
	
	private Mensagem mensagem;
	
	private Pessoa usuario;

	private Pessoa contato;
	
	private String justificativa;

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
	
	@Transient
	public XMLGregorianCalendar getDataHoraIncl() {
		return dataHoraIncl;
	}
	public void setDataHoraIncl(XMLGregorianCalendar dataHoraIncl) {
		this.dataHoraIncl = dataHoraIncl;
	}
	
	@Column(name="DATA_HORA_INCL")
	public Calendar getDataHoraInclCal() {
		return Uteis.xmlGregorianCalendarToCalendar(dataHoraIncl);
	}
	public void setDataHoraInclCal(Calendar dataHoraIncl) {
		setDataHoraIncl(Uteis.calendarToXmlGregorianCalendar(dataHoraIncl));
	}
	
	@ManyToOne
	@JoinColumn(name="MENSAGEM_ID")
	public Mensagem getMensagem() {
		return mensagem;
	}
	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
	
	@ManyToOne
	@JoinColumn(name="PESSOA_ID")
	public Pessoa getUsuario() {
		return usuario;
	}
	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}
	
	@ManyToOne
	@JoinColumn(name="CONTATO_ID")
	public Pessoa getContato() {
		return contato;
	}
	public void setContato(Pessoa contato) {
		this.contato = contato;
	}
	
	@Column(name="JUSTIFICATIVA")
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	
}
