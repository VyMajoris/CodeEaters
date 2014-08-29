package br.com.fiap.pacote.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.impl.DAOImpl;
import br.com.fiap.pacote.dao.PacoteDAO;
import br.com.fiap.pacote.entity.Pacote;

public class PacoteDAOImpl extends DAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarTodos() {
		TypedQuery<Pacote> query = em.createQuery("from Pacote",Pacote.class);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDescricao(String descricao) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.descricao like :desc",Pacote.class);
		query.setParameter("desc","%"+descricao+"%");
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorPeriodo(Calendar inicio, Calendar fim) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.dataSaida between :inicio and :fim",Pacote.class);
		query.setParameter("inicio",inicio);
		query.setParameter("fim", fim);
		return query.getResultList();
	}

}
