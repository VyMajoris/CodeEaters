package br.com.helpradar.dao.impl;

import javax.persistence.EntityManager;

import br.com.helpradar.dao.UsuarioDAO;
import br.com.helpradar.entity.Usuario;

public class UsuarioDAOImpl extends DAOImpl<Usuario,Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
