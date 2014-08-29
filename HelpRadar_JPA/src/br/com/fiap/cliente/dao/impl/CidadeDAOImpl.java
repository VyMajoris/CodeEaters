package br.com.fiap.cliente.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.cliente.dao.CidadeDAO;
import br.com.fiap.cliente.entity.Cidade;
import br.com.fiap.dao.impl.DAOImpl;

public class CidadeDAOImpl extends DAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
