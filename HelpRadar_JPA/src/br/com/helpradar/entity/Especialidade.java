package br.com.helpradar.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqEspecialidade", sequenceName="SEQ_ESPECIALIDADE", allocationSize=1)
public class Especialidade {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEspecialidade")
	private int id;
	
	 @ManyToMany(mappedBy = "especialidade")  
	 private Set<Usuario> usuario = new HashSet<Usuario>();  
	
	
	/**
	 * @param usuario
	 * @param nomeEspecialidade
	 */
	public Especialidade(Set<Usuario> usuario, String nomeEspecialidade) {
		super();
		this.usuario = usuario;
		this.nomeEspecialidade = nomeEspecialidade;
	}

	public Especialidade() {
		super();
	}

	private String nomeEspecialidade;

	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}

	public Especialidade(String nomeEspecialidade) {
		super();
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
