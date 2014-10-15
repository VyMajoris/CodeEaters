package br.com.helpradar.entity;

import java.io.Serializable;
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
public class Usuario implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1501771317477082613L;

	//O ID será provido pelo API de login
	@Id
	private Long userId;

	//Nome será provida pela API de login, mas poderá ser mudado
	@Column(nullable=false)
	private String nome;



	@OneToOne
	private Contato contato;

	private TipoUsuario tipoUsuario;



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
	public Usuario(Long id, String nome, 
			Contato contato,
			TipoUsuario tipoUsuario) {
		super();
		this.userId = id;
		this.nome = nome;
		

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
	public Usuario(String nome,  TipoUsuario tipoUsuario,
			 Identificacao identificacao,
			Set<Avaliacao> avaliacao, Set<Especialidade> especialidade) {
		super();
		this.nome = nome;
		
		this.tipoUsuario = tipoUsuario;
		
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





	


	public Long getUserId() {
		return userId;
	}

	public void setuserId(Long userId) {
		this.userId = userId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
