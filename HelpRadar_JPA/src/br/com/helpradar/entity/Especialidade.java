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
@SequenceGenerator(name="seqEspecialidade", sequenceName="SEQ_ESPECIALIDADE", allocationSize=1)
public class Especialidade {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEspecialidade")
	private int id;
	
	private String nomeEspecialidade;

	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}

	public Especialidade(int id, String nomeEspecialidade) {
		super();
		this.id = id;
		this.nomeEspecialidade = nomeEspecialidade;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
