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

	/**
	 * Usuário
	 * @param id
	 * @param nome
	 * @param social
	 * @param listaAmigos
	 * @param contato
	 * @param tipoUsuario
	 */
	public Usuario(int id, String nome, boolean social,
			List<Usuario> listaAmigos, Contato contato,
			TipoUsuario tipoUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.social = social;
		this.listaAmigos = listaAmigos;
		this.contato = contato;
		this.tipoUsuario = tipoUsuario;
	}


	/**
	 * Assistente
	 * @param tipoUsuario
	 * @param diaLogado
	 * @param identificacao
	 * @param listaAvaliacoes
	 */
	public Usuario(TipoUsuario tipoUsuario, boolean diaLogado,
			Identificacao identificacao, List<Avaliacao> listaAvaliacoes) {
		super();
		this.tipoUsuario = tipoUsuario;
		this.diaLogado = diaLogado;
		this.identificacao = identificacao;
		this.listaAvaliacoes = listaAvaliacoes;
	}


	//O ID será provido pelo API de login
	@Id
	private int id;

	//Nome será provida pela API de login, mas poderá ser mudado
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


	private TipoUsuario tipoUsuario;


	//ASSISTENTE
	private boolean diaLogado;

	@OneToOne
	private Identificacao identificacao;

	@OneToMany@ElementCollection
	private List<Avaliacao> listaAvaliacoes;
	//ASSISTENTE

	public int getId() {
		return id;
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

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public boolean isDiaLogado() {
		return diaLogado;
	}

	public void setDiaLogado(boolean diaLogado) {
		this.diaLogado = diaLogado;
	}

	public Identificacao getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(Identificacao identificacao) {
		this.identificacao = identificacao;
	}

	public List<Avaliacao> getListaAvaliacoes() {
		return listaAvaliacoes;
	}

	public void setListaAvaliacoes(List<Avaliacao> listaAvaliacoes) {
		this.listaAvaliacoes = listaAvaliacoes;
	}






}
