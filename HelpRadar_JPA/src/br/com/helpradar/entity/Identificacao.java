package br.com.helpradar.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqIdentificacao", sequenceName="SEQ_IDENTIFICACAO", allocationSize=1)
public class Identificacao {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqIdentificacao")
	private int id;

	public Identificacao(){

	}


	//pecas de roupas
	//sera guardada no banco todas as peça para mostrar por meio de auto-complete para o assisente re-inserir
	@ElementCollection
	private List<String> pecas;







	/**
	 * @param id
	 * @param pecas
	 */
	public Identificacao(List<String> pecas) {
		super();

		this.pecas = pecas;
	}



	public void setId(int id) {
		this.id = id;
	}



	public List<String> getPecas() {
		return pecas;
	}

	public void setPecas(List<String> pecas) {
		this.pecas = pecas;
	}


	public int getId() {
		return id;
	}





}
