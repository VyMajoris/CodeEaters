package br.com.helpradar.dao;

import java.util.List;

import br.com.helpradar.entity.Assistente;
import br.com.helpradar.entity.Avaliacao;

public interface AssistenteDAO extends DAO<Assistente,Integer>{
	
	List<Avaliacao> buscarAvalicoesPorAssistente(Assistente assistente);
	
	List<Assistente> BuscarAssistentePorEspecialidade(String especialidadeNome);
	
	

}
