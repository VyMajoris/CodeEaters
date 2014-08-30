package br.com.helpradar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import br.com.helpradar.dao.EspecialidadeDAO;
import br.com.helpradar.entity.Especialidade;

public class EspecialidadeDAOImpl extends DAOImpl<Especialidade,Integer> implements EspecialidadeDAO {

	public EspecialidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Especialidade> buscaPorNome(String nome) {
		TypedQuery<Especialidade> query = em.createQuery("from Especialidade e where e.nomeEspecialidade like '%:nome'",Especialidade.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}

	@Override
	public List<Especialidade> buscarTodos() {
		TypedQuery<Especialidade> query = em.createQuery("from Especialidade",Especialidade.class);
		return query.getResultList();
	}

}
