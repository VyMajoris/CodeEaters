package br.com.helpradar.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.helpradar.dao.EntityManagerFactorySingleton;
import br.com.helpradar.dao.EspecialidadeDAO;
import br.com.helpradar.dao.impl.EspecialidadeDAOImpl;
import br.com.helpradar.entity.Especialidade;


//Mudar de cliente para usuario
@ManagedBean
@RequestScoped
public class BuscaCliente implements Serializable{
	
	private static final long serialVersionUID = 1213123L;

	private List<Especialidade> listaEspecialidade;
	private EspecialidadeDAO dao;
	private String nomeBusca;

	@PostConstruct
	private void init(){
		EntityManager em = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		dao = new EspecialidadeDAOImpl(em);
		
		setListaEspecialidade(dao.buscarTodos());
		
	}
	
	public List<Especialidade> buscarNomes(){
		return dao.buscaPorNome(nomeBusca);
	}
	
	
	public void buscarTodos() {
		setListaEspecialidade(dao.buscarTodos());
		
	}

	public List<Especialidade> getListaEspecialidade() {
		return listaEspecialidade;
	}

	public void setListaEspecialidade(List<Especialidade> listaEspecialidade) {
		this.listaEspecialidade = listaEspecialidade;
	}
	
	
}
