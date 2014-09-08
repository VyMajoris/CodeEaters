package br.com.helpradar.entity;


import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqAssistente", sequenceName="SEQ_ASSISTENTE", allocationSize=1)
public class Assistente {

	//registra se o assistente ja se logou no dia corrente
	//caso nao, sera pedido ao assisente para atualizar sua identificao
	private boolean diaLogado;
	
	private int id;

	@OneToOne
	private Identificacao identificacao;

	@OneToMany@ElementCollection
	private List<Avaliacao> listaAvaliacoes;

	@OneToOne
	private Usuario usuario;
	
	public Assistente(int id, boolean diaLogado,  Identificacao identificacao,
			List<Avaliacao> listaAvaliacoes, Usuario usuario) {
		super();
		this.diaLogado = diaLogado;
		this.id = id;
		this.identificacao = identificacao;
		this.listaAvaliacoes = listaAvaliacoes;
		this.usuario = usuario;
	}



	public Assistente(){
		
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public boolean isDiaLogado() {
		return diaLogado;
	}

	public void setDiaLogado(boolean diaLogado) {
		this.diaLogado = diaLogado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}





}
