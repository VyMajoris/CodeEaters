package br.com.helpradar.entity;


import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqAssistente", sequenceName="SEQ_ASSISTENTE", allocationSize=1)
public class Assistente extends Usuario {


	
	
	
	//uma imagem para ser mostrada ao lado do avatar do assistente
	@Lob
	private byte[] banner;
	


	//registra se o assistente ja se logou no dia corrente
	//caso nao, sera pedido ao assisente para atualizar sua identificao
	private boolean diaLogado;


	public boolean isDiaLogado() {
		return diaLogado;
	}

	public void setDiaLogado(boolean diaLogado) {
		this.diaLogado = diaLogado;
	}

	public byte[] getBanner() {
		return banner;
	}

	public void setBanner(byte[] banner) {
		this.banner = banner;
	}
	

}
