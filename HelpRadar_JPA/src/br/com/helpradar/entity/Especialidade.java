package br.com.helpradar.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqReserva", sequenceName="SEQ_RESERVA", allocationSize=1)
public class Especialidade {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqReserva")
	private int id;
	
	@Column(name="NUMERO_DIAS")
	private int numeroDias;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_RESERVA")
	private Calendar dataReserva;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Avaliacao pacote;
	
	@ManyToOne
	private Identificacao cliente;
	
	public Especialidade(int numeroDias, Calendar dataReserva, Avaliacao pacote, Identificacao cliente) {
		super();
		this.numeroDias = numeroDias;
		this.dataReserva = dataReserva;
		this.pacote = pacote;
		this.cliente = cliente;
	}

	public Especialidade() {
	}

	public int getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(int numeroDias) {
		this.numeroDias = numeroDias;
	}

	public Calendar getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Calendar dataReserva) {
		this.dataReserva = dataReserva;
	}

	public int getId() {
		return id;
	}

	public Avaliacao getPacote() {
		return pacote;
	}

	public void setPacote(Avaliacao pacote) {
		this.pacote = pacote;
	}

	public Identificacao getCliente() {
		return cliente;
	}

	public void setCliente(Identificacao cliente) {
		this.cliente = cliente;
	}
}
