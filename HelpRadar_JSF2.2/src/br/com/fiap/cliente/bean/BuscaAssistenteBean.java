package br.com.fiap.cliente.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.helpradar.dao.EntityManagerFactorySingleton;
import br.com.helpradar.dao.EspecialidadeDAO;
import br.com.helpradar.dao.UsuarioDAO;
import br.com.helpradar.dao.impl.EspecialidadeDAOImpl;
import br.com.helpradar.dao.impl.UsuarioDAOImpl;
import br.com.helpradar.entity.Usuario;
@ManagedBean
@RequestScoped
public class BuscaAssistenteBean implements Serializable {
	

	
	//Armazena o nome da busca inserido pelo usuário
	private String testJSF = "test123";
	private String nomeEspecialidadeBusca;
	private List<Usuario> listaAssistente;
	private UsuarioDAO userDAO;
	private EspecialidadeDAO espDAO;
	

	@PostConstruct
	private void init(){
		EntityManager em = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		userDAO = new UsuarioDAOImpl(em);
		espDAO = new EspecialidadeDAOImpl(em);
		listaAssistente = new ArrayList<Usuario>();
		
	}
	
	
	// Trata o clique do botão Buscar
		public void buscarPorNomeEspecialidade() {
			// Atualiza a lista da tabela com a busca por nome
			listaAssistente = userDAO.BuscarAssistentePorNomeEspecialidade(nomeEspecialidadeBusca);
		}
	
	//Autocomplete dos nomes da especialdiades
	public List<String> completarNome(String nome) {
		return espDAO.buscarTodosNomes();
	}
	



	public List<Usuario> getListaAssistente() {
		return listaAssistente;
	}

	public void setListaAssistente(List<Usuario> listaAssistente) {
		this.listaAssistente = listaAssistente;
	}

	public String getNomeEspecialidadeBusca() {
		return nomeEspecialidadeBusca;
	}

	public void setNomeEspecialidadeBusca(String nomeEspecialidadeBusca) {
		this.nomeEspecialidadeBusca = nomeEspecialidadeBusca;
	}


	public String getTestJSF() {
		return testJSF;
	}


	public void setTestJSF(String testJSF) {
		this.testJSF = testJSF;
	}

	
	

	
	
}
