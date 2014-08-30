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
@SequenceGenerator(name="seqIdentificacao", sequenceName="SEQ_IDENTIFICACAO", allocationSize=1)
public class Identificacao {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqIdentificacao")
	private int id;
	
	@OneToOne
	private Assistente assitente;
	
	
	@Lob
	private byte[] foto;
	
	public int getId() {
		return id;
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

	//peças de roupas
	//será guardada no banco todas as peça para mostrar por meio de auto-complete para o assisente re-inserir
	private List<String> pecas;

	public List<String> getPecas() {
		return pecas;
	}

	public void setPecas(List<String> pecas) {
		this.pecas = pecas;
	}

	public Assistente getAssitente() {
		return assitente;
	}

	public void setAssitente(Assistente assitente) {
		this.assitente = assitente;
	}
	
	
	
}
