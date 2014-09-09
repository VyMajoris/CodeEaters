package br.com.helpradar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.helpradar.dao.UsuarioDAO;

import br.com.helpradar.entity.Avaliacao;
import br.com.helpradar.entity.Especialidade;
import br.com.helpradar.entity.Identificacao;
import br.com.helpradar.entity.Usuario;

public class UsuarioDAOImpl extends DAOImpl<Usuario,Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	
	

	@Override
	public List<Avaliacao> buscarAvalicoesPorAssistente(int assistId) {
		TypedQuery<Avaliacao> query = em.createQuery("Select avaliacao from Usuario where usuario.id = :AssistID",Avaliacao.class);
		query.setParameter("AssistID", "%"+assistId+"%");
		return query.getResultList();
	}
	
	
	@Override
	public List<Identificacao> buscarIdentificacaoPorAssistente(int assistId) {
		TypedQuery<Identificacao> query = em.createQuery("Select usuario.identificacao from Usuario where usuario.id = :AssistID",Identificacao.class);
		query.setParameter("AssistID", "%"+assistId+"%");
		return query.getResultList();
	}
	
	

	@Override
	public List<Usuario> BuscarAssistentePorEspecialidade(int espID) {
		TypedQuery<Usuario> query = em.createQuery("Select Usuario from especialidade where especialidade.id = :espID",Usuario.class);
		query.setParameter("espID", "%"+espID+"%");
		return query.getResultList();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
