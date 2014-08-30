package br.com.helpradar.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import br.com.helpradar.dao.IdentificacaoDAO;
import br.com.helpradar.entity.Identificacao;

public class IdentificacaoDAOImpl extends DAOImpl<Identificacao,Integer> implements IdentificacaoDAO{

	public IdentificacaoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	

	@Override
	public List<Identificacao> buscarPorDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Identificacao> buscarPorPeriodo(Calendar inicio, Calendar fim) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Identificacao> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}







