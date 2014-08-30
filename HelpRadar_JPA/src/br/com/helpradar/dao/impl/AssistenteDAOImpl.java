package br.com.helpradar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;



import javax.persistence.TypedQuery;

import br.com.helpradar.dao.AssistenteDAO;
import br.com.helpradar.entity.Assistente;
import br.com.helpradar.entity.Avaliacao;

public class AssistenteDAOImpl extends DAOImpl<Assistente,Integer> implements AssistenteDAO{

	public AssistenteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Avaliacao> buscarAvalicoesPorAssistente(Assistente assistente) {
		TypedQuery<Avaliacao> query = em.createQuery("Select avaliacao from Assistente where assistente.id = :AssistID",Avaliacao.class);
		query.setParameter("AssistID", "%"+assistente.getId()+"%");
		return query.getResultList();
		
	}

	@Override
	public List<Assistente> BuscarAssistentePorEspecialidade(
			String especialidadeNome) {
		TypedQuery<Assistente> query = em.createQuery("Select Assistente from especialidade where especialidade.nomeEspecialidade like ':nomeEspecialidade%'",Assistente.class);
		query.setParameter("nomeEspecialidade", "%"+especialidadeNome+"%");
		return query.getResultList();
	}

}
