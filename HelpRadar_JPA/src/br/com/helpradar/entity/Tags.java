package br.com.helpradar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqTags", sequenceName="SEQ_TAGS", allocationSize=1)
public class Tags {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqTags")
	private int id;
	
	private String tag;
	
	@ManyToOne
	private Avaliacao avaliacao;



	public Tags(int id, String tag, Avaliacao avaliacao) {
		super();
		this.id = id;
		this.tag = tag;
		this.avaliacao = avaliacao;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
}
