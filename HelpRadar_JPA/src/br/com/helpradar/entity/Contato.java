package br.com.helpradar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqCidade", sequenceName="SEQ_CIDADE", allocationSize=1)
public class Contato {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCidade")
	private int id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(length=2,nullable=false)
	private String uf;
	
	private int ddd;
	
	@Column(name="NR_HABITANTES")
	private int nrHabitantes;

	public Contato(String nome, String uf, int ddd, int nrHabitantes) {
		super();
		this.nome = nome;
		this.uf = uf;
		this.ddd = ddd;
		this.nrHabitantes = nrHabitantes;
	}

	public Contato() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getNrHabitantes() {
		return nrHabitantes;
	}

	public void setNrHabitantes(int nrHabitantes) {
		this.nrHabitantes = nrHabitantes;
	}

	public int getId() {
		return id;
	}

}
