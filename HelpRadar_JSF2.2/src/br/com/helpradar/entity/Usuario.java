package br.com.helpradar.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
	 * @param avatar
	 */
	public Usuario(Long id, String nome, boolean social,
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
	 * @param nome
	 * @param avatar
	 * @param tipoUsuario
	 * @param diaLogado
	 * @param identificacao
	 * @param listaAvaliacoes
	 * @param especialidade
	 */
	public Usuario(String nome, byte[] avatar, TipoUsuario tipoUsuario,
			boolean diaLogado, Identificacao identificacao,
			Set<Avaliacao> avaliacao, Set<Especialidade> especialidade) {
		super();
		this.nome = nome;
		this.avatar = avatar;
		this.tipoUsuario = tipoUsuario;
		this.diaLogado = diaLogado;
		this.identificacao = identificacao;
		this.avaliacao = avaliacao;
		this.especialidade = especialidade;
	}





	public Usuario() {
		// TODO Auto-generated constructor stub
	}





	public Set<Especialidade> getEspecialidade() {
		return especialidade;
	}


	public void setEspecialidade(Set<Especialidade> especialidade) {
		this.especialidade = especialidade;
	}





	//O ID será provido pelo API de login
	@Id
	private Long id;

	//Nome será provida pela API de login, mas poderá ser mudado
	@Column(nullable=false)
	private String nome;

	//TRUE = GOOGLE+
	//FALSE = FACEBOOK
	@Column(nullable=false)
	private boolean social;

	@OneToMany
	@ElementCollection
	@Column(name="AMIGO")
	private List<Usuario> listaAmigos;

	@Lob
	private byte[] avatar;



	public byte[] getAvatar() {
		return avatar;
	}


	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}


	@OneToOne
	private Contato contato;


	private TipoUsuario tipoUsuario;


	//////////ASSISTENTE
	private boolean diaLogado;

	@OneToOne
	private Identificacao identificacao;

	@ManyToMany(cascade = { CascadeType.ALL })  
	@JoinTable(name = "USUARIO_AVALIACAO", 
	joinColumns = { @JoinColumn(name = "USUARIO_ID") },
	inverseJoinColumns = { @JoinColumn(name = "AVALIACAO_ID") })  
	@Column(name="AVALIACAO")

	private Set<Avaliacao> avaliacao = new HashSet<Avaliacao>();  

	@ManyToMany(cascade = { CascadeType.ALL })  
	@JoinTable(name = "USUARIO_ESPECIALIDADE", 
	joinColumns = { @JoinColumn(name = "USUARIO_ID") },
	inverseJoinColumns = { @JoinColumn(name = "ESPECIALIDADE_ID") })  
	@Column(name="ESPECIALIDADE")

	private Set<Especialidade> especialidade = new HashSet<Especialidade>();  
	/////////ASSISTENTE

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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





	public Set<Avaliacao> getAvaliacao() {
		return avaliacao;
	}





	public void setAvaliacao(Set<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}








}
