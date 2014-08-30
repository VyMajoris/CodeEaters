package br.com.helpradar.entity;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqAvaliacao", sequenceName="SEQ_AVALIACAO", allocationSize=1)
public class Avaliacao {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAvaliacao")
	private int id;
	

	private String descricao;

	//será provida a Data do sistema no input, mas o usuário poderá alterar
	private Date dataAvaliacao;

	private String titulo;


	// 1..5 Integer. para poder ser null
	private Integer nota;



	public Avaliacao(int id,
			String descricao, Date dataAvaliacao, String titulo, Integer nota) {
		super();
		this.id = id;
	
		this.descricao = descricao;
		this.dataAvaliacao = dataAvaliacao;
		this.titulo = titulo;
		this.nota = nota;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getNota() {
		return nota;
	}


	public void setNota(Integer nota) {
		this.nota = nota;
	}


	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}


	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}
	
	

	
	

}
