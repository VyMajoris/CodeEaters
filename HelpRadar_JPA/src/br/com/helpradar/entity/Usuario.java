package br.com.helpradar.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity
@SequenceGenerator(name="seqUsuario", sequenceName="SEQ_USUARIO", allocationSize=1)
public class Usuario {

	//O ID será provido pelo API de login
	@Id
	private int id;

	//Nome será provida pela API de login, mas poderá ser mudado
	@Column(nullable=false)
	private String nome;

	//Foto será provida pela API de login, mas poderá ser mudado
	@Lob
	private byte[] foto;

	//TRUE = GOOGLE+
	//FALSE = FACEBOOK
	@Column(nullable=false)
	private boolean social;

	public Usuario(int id, String nome, byte[] foto, boolean social,
			List<Usuario> listaAmigos) {
		super();
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.social = social;
		this.listaAmigos = listaAmigos;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToMany
	private List<Usuario> listaAmigos;





	public Usuario() {
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
