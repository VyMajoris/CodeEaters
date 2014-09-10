package br.com.helpradar.dao.impl;



import javax.persistence.EntityManager;




import br.com.helpradar.dao.ContatoDAO;

import br.com.helpradar.entity.Contato;


public class ContatoDAOImpl extends DAOImpl<Contato,Integer> implements ContatoDAO{

	public ContatoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}





}







