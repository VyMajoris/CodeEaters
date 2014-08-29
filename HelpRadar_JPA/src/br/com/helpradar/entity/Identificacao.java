package br.com.helpradar.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqCliente", sequenceName="SEQ_CLIENTE", allocationSize=1)
public class Identificacao {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCliente")
	private int id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(length=14,nullable=false)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASCIMENTO")
	private Calendar dataNascimento = Calendar.getInstance();
	
	@OneToOne(cascade=CascadeType.ALL)
	private Assistente endereco;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Avaliacao> pacotes;
	
	//Propriedade para armazenar informações grandes
	//Lob -> Mapeia uma coluna do tipo BLOB no banco de dados.
	@Lob
	private byte[] foto;
	
	@Column(name="DS_CATEGORIA")
	private Integer categoria;

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Identificacao(String nome, String cpf, Calendar dataNascimento, Assistente endereco, List<Avaliacao> pacotes) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.pacotes = pacotes;
	}
	
	public Identificacao() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public Assistente getEndereco() {
		return endereco;
	}

	public void setEndereco(Assistente endereco) {
		this.endereco = endereco;
	}

	public List<Avaliacao> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Avaliacao> pacotes) {
		this.pacotes = pacotes;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}
