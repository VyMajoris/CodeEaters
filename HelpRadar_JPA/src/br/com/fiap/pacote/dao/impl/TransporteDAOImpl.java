package br.com.fiap.pacote.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.DAOImpl;
import br.com.fiap.pacote.dao.TransporteDAO;
import br.com.fiap.pacote.entity.Transporte;

public class TransporteDAOImpl extends DAOImpl<Transporte,Integer> implements TransporteDAO{

	public TransporteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
