package br.com.helpradar.dao.impl;




import javax.persistence.EntityManager;

import br.com.helpradar.dao.AvaliacaoDAO;
import br.com.helpradar.entity.Avaliacao;

public class AvaliacaoDAOImpl extends DAOImpl<Avaliacao,Integer> implements AvaliacaoDAO{

	public AvaliacaoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


	
}
