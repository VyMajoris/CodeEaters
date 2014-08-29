package br.com.helpradar.dao.impl;

import javax.persistence.EntityManager;


import br.com.helpradar.dao.AssistenteDAO;
import br.com.helpradar.entity.Assistente;

public class AssistenteDAOImpl extends DAOImpl<Assistente,Integer> implements AssistenteDAO{

	public AssistenteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
