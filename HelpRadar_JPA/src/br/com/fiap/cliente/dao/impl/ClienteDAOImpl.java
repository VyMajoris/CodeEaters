package br.com.fiap.cliente.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.cliente.dao.ClienteDAO;
import br.com.fiap.cliente.entity.Cliente;
import br.com.fiap.dao.impl.DAOImpl;

public class ClienteDAOImpl extends DAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> buscarTodos() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente",Cliente.class);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.nome like :nome",Cliente.class);
		query.setParameter("nome","%"+ nome + "%");
		return query.getResultList();
	}

	@Override
	public List<String> buscarNome(String nome) {
		//Buscar os nomes dos clientes pela parte do nome...
		TypedQuery<String> query =
				em.createQuery("select c.nome from Cliente c where "
						+ "c.nome like :p1",String.class);
		query.setParameter("p1", "%"+ nome + "%");
		return query.getResultList();
	}

}







