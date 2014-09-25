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
		TypedQuery<Avaliacao> query = em.createQuery("Select avaliacao from Usuario where usuario.id = :AssistID and rownum <= 10  order by dataAvaliacao;",Avaliacao.class);
		query.setParameter("AssistID", "%"+assistId+"%");
		return query.getResultList();
	}
	
	
	@Override
	public Identificacao buscarIdentificacaoPorAssistente(int assistId) {
		TypedQuery<Identificacao> query = em.createQuery("Select identificacao from Usuario where usuario.id = :AssistID",Identificacao.class);
		query.setParameter("AssistID", "%"+assistId+"%");
		return query.getSingleResult();
	}
	
	

	@Override
	public List<Usuario> BuscarAssistentePorEspecialidade(int espID) {
		TypedQuery<Usuario> query = em.createQuery("from usuario where usuario.especialidade.id = :espID ",Usuario.class);
		query.setParameter("espID", "%"+espID+"%");
		return query.getResultList();
	}

	
	@Override
	public List<Usuario> BuscarAssistentePorEspecialidadeGPS(int espID) {
		TypedQuery<Usuario> query = em.createQuery("Select id, avatar from Usuario where especialidade.id = :espID",Usuario.class);
		query.setParameter("espID", "%"+espID+"%");
		return query.getResultList();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
