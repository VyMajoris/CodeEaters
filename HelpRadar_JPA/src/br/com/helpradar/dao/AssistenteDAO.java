package br.com.helpradar.dao;

import java.util.List;

import br.com.helpradar.entity.Assistente;
import br.com.helpradar.entity.Avaliacao;
import br.com.helpradar.entity.Especialidade;
import br.com.helpradar.entity.Identificacao;

public interface AssistenteDAO extends DAO<Assistente,Integer>{
	
	List<Avaliacao> buscarAvalicoesPorAssistente(Assistente assistente);
	
	List<Identificacao> buscarIdentificacaoPorAssistente(Assistente assistente);
	
	List<Assistente> BuscarAssistentePorEspecialidade(Especialidade especialidade);
	
	

}
