package br.com.mensagem.entidades;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import br.com.mensagem.uteis.Uteis;

@Entity
@Table(name="AGENDA", schema="mydb")
@XmlRootElement
@XmlType(propOrder = { 
		"id", 
		"dataInicial", 
		"horaInicial", 
		"intervaloEmHoras", 
		"dataFim",
		"grupoDestinatarios",
		"destinatarioUnico",
		"mensagem"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Agenda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@XmlElement(name="dataInicial")
	@XmlSchemaType(name="dateTime", type=javax.xml.datatype.XMLGregorianCalendar.class)
	private XMLGregorianCalendar dataInicial;
	
	private Integer intervaloHoras;
	
	@XmlElement(name="dataFim")
	@XmlSchemaType(name="dateTime", type=javax.xml.datatype.XMLGregorianCalendar.class)
	private XMLGregorianCalendar dataFim;
	
	private TipoGrupoDestinatarios grupoDestinatarios;
	
	private Pessoa destinatarioUnico;
	
	private Mensagem mensagem;

	//--------- get's e set's
	
	@Id
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	public XMLGregorianCalendar getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(XMLGregorianCalendar dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	@Column(name="DATA_INI")
	public Calendar getDataInicialCal() {
		return Uteis.xmlGregorianCalendarToCalendar(dataInicial);
	}
	public void setDataInicialCal(Calendar dataInicialCal) {
		setDataInicial(Uteis.calendarToXmlGregorianCalendar(dataInicialCal));
	}

	@Column(name="INTERVALO_EM_HORAS")
	public Integer getIntervaloHoras() {
		return intervaloHoras;
	}
	public void setIntervaloHoras(Integer intervaloHoras) {
		this.intervaloHoras = intervaloHoras;
	}

	@Transient
	public XMLGregorianCalendar getDataFim() {
		return dataFim;
	}
	public void setDataFim(XMLGregorianCalendar dataFim) {
		this.dataFim = dataFim;
	}
		
	@Column(name="DATA_FIM")
	public Calendar getDataFimCal() {
		return Uteis.xmlGregorianCalendarToCalendar(dataFim);
	}
	public void setDataFimCal(Calendar dataFim) {
		setDataFim(Uteis.calendarToXmlGregorianCalendar(dataFim));
	}

	@ManyToOne
	@JoinColumn(name="TIPO_FILTRO_PESSOA_ID")
	public TipoGrupoDestinatarios getGrupoDestinatarios() {
		return grupoDestinatarios;
	}
	public void setGrupoDestinatarios(TipoGrupoDestinatarios grupoDestinatarios) {
		this.grupoDestinatarios = grupoDestinatarios;
	}

	@ManyToOne
	@JoinColumn(name="PESSOA_ID")
	public Pessoa getDestinatarioUnico() {
		return destinatarioUnico;
	}
	public void setDestinatarioUnico(Pessoa destinatarioUnico) {
		this.destinatarioUnico = destinatarioUnico;
	}

	@ManyToOne
	@JoinColumn(name="MENSAGEM_ID")
	public Mensagem getMensagem() {
		return mensagem;
	}
	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
	
}
