package br.com.helpradar.dao.impl;

import javax.persistence.EntityManager;


import br.com.helpradar.dao.TagsDAO;
import br.com.helpradar.entity.Tags;

public class TagsDAOImpl extends DAOImpl<Tags,Integer> implements TagsDAO{

	public TagsDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
