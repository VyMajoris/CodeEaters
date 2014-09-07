package br.com.helpradar.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;



@Entity
@SequenceGenerator(name="seqUsuario", sequenceName="SEQ_USUARIO", allocationSize=1)
public class Usuario {

	public Usuario(int id, String nome, boolean social,
			List<Usuario> listaAmigos, Contato contato) {
		super();
		this.id = id;
		this.nome = nome;
		this.social = social;
		this.listaAmigos = listaAmigos;
		this.contato = contato;
	}

	//O ID ser� provido pelo API de login
	@Id
	private int id;

	//Nome ser� provida pela API de login, mas poder� ser mudado
	@Column(nullable=false)
	private String nome;

	//TRUE = GOOGLE+
	//FALSE = FACEBOOK
	@Column(nullable=false)
	private boolean social;

	@OneToMany
	@ElementCollection
	private List<Usuario> listaAmigos;

	@OneToOne
	private Contato contato;

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getId() {
		return id;
	}

	public boolean isSocial() {
		return social;
	}

	public void setSocial(boolean social) {
		this.social = social;
	}

	public List<Usuario> getListaAmigos() {
		return listaAmigos;
	}

	public void setListaAmigos(List<Usuario> listaAmigos) {
		this.listaAmigos = listaAmigos;
	}



}
