package br.com.helpradar.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqAvaliacao", sequenceName="SEQ_AVALIACAO", allocationSize=1)
public class Avaliacao {

	/**
	 * @param usuario
	 * @param descricao
	 * @param dataAvaliacao
	 * @param titulo
	 * @param nota
	 */
	public Avaliacao(Set<Usuario> usuario, String descricao,
			Calendar dataAvaliacao, String titulo, Integer nota) {
		super();
		this.usuario = usuario;
		this.descricao = descricao;
		this.dataAvaliacao = dataAvaliacao;
		this.titulo = titulo;
		this.nota = nota;
	}
	
	public Avaliacao(){
		
	}


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAvaliacao")
	private int id;
	
	 @ManyToMany(mappedBy = "avaliacao")  
	 private Set<Usuario> usuario = new HashSet<Usuario>(); 
	

	private String descricao;

	//será provida a Data do sistema no input, mas o usuário poderá alterar
	private Calendar dataAvaliacao;

	private String titulo;


	// 1..5 Integer. para poder ser null
	private Integer nota;



	

	public Avaliacao(int id, String descricao, Calendar dataAvaliacao,
			String titulo, Integer nota) {
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


	public Calendar getDataAvaliacao() {
		return dataAvaliacao;
	}


	public void setDataAvaliacao(Calendar dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}


	public Set<Usuario> getUsuario() {
		return usuario;
	}


	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}






	
	
	

	
	

}
