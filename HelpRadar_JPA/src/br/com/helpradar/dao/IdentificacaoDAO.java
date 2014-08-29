package br.com.helpradar.dao;

import java.util.Calendar;
import java.util.List;

import br.com.helpradar.entity.Identificacao;

public interface IdentificacaoDAO extends DAO<Identificacao,Integer>{

	List<Identificacao> buscarTodos();
	
	List<Identificacao> buscarPorDescricao(String descricao);
	
	List<Identificacao> buscarPorPeriodo(Calendar inicio, Calendar fim);
}
