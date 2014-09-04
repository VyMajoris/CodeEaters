package br.com.helpradar.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqContato", sequenceName="SEQ_CONTATO", allocationSize=1)
public class Contato {


	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqContato")
	private int id;
	
	
	//O Email no contato pode ser outro email além do email de cadastro
	private List<String> emailPublicos;
	
	//String para se adaptar facilmente com os diversos formatos de telefones pelo mundo
	private List<String> telefones;
	
	//Uma lista de links de profiles de redes sociais extras, como LinkedIn
	private List<String> social;
	
	//Será mostrado um link para a página do google+/facebook, caso o assistente deseje. Por isso, só é necessário um boolean
	private boolean mostraPerfil;


	public Contato(int id, List<String> emailPublicos,
			List<String> telefones, List<String> social, boolean mostraPerfil) {
		super();
		this.id = id;
		this.emailPublicos = emailPublicos;
		this.telefones = telefones;
		this.social = social;
		this.mostraPerfil = mostraPerfil;
	}

	public List<String> getEmailPublicos() {
		return emailPublicos;
	}

	public void setEmailPublicos(List<String> emailPublicos) {
		this.emailPublicos = emailPublicos;
	}

	public boolean isMostraPerfil() {
		return mostraPerfil;
	}

	public void setMostraPerfil(boolean mostrarPerfil) {
		this.mostraPerfil = mostrarPerfil;
	}

	public List<String> getSocial() {
		return social;
	}

	public void setSocial(List<String> social) {
		this.social = social;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	


	
	

}
