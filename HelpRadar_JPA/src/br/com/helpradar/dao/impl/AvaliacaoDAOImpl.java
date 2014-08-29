package br.com.helpradar.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import br.com.helpradar.dao.AvaliacaoDAO;
import br.com.helpradar.entity.Avaliacao;

public class AvaliacaoDAOImpl extends DAOImpl<Avaliacao,Integer> implements AvaliacaoDAO{

	public AvaliacaoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Avaliacao> buscarTodos() {
		TypedQuery<Avaliacao> query = em.createQuery("from Pacote",Avaliacao.class);
		return query.getResultList();
	}

	@Override
	public List<Avaliacao> buscarPorDescricao(String descricao) {
		TypedQuery<Avaliacao> query = em.createQuery("from Pacote p where p.descricao like :desc",Avaliacao.class);
		query.setParameter("desc","%"+descricao+"%");
		return query.getResultList();
	}

	@Override
	public List<Avaliacao> buscarPorPeriodo(Calendar inicio, Calendar fim) {
		TypedQuery<Avaliacao> query = em.createQuery("from Pacote p where p.dataSaida between :inicio and :fim",Avaliacao.class);
		query.setParameter("inicio",inicio);
		query.setParameter("fim", fim);
		return query.getResultList();
	}

}
