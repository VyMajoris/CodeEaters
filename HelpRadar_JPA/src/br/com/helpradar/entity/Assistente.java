package br.com.helpradar.entity;


import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqAssistente", sequenceName="SEQ_ASSISTENTE", allocationSize=1)
public class Assistente extends Usuario {
	
	//registra se o assistente ja se logou no dia corrente
	//caso nao, sera pedido ao assisente para atualizar sua identificao
	private boolean diaLogado;

	@OneToOne
	private Identificacao identificacao;
	
	@OneToMany@ElementCollection
	private List<Avaliacao> listaAvaliacoes;
	

	public Assistente(int id, String nome, boolean social,
			List<Usuario> listaAmigos, Contato contato, boolean diaLogado,
			Identificacao identificacao, List<Avaliacao> listaAvaliacoes) {
		super(id, nome, social, listaAmigos, contato);
		this.diaLogado = diaLogado;
		this.identificacao = identificacao;
		this.listaAvaliacoes = listaAvaliacoes;
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



	

}
