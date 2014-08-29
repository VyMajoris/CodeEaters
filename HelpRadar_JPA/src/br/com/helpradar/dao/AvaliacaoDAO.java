package br.com.helpradar.dao;

import java.util.Calendar;
import java.util.List;

import br.com.helpradar.entity.Avaliacao;

public interface AvaliacaoDAO extends DAO<Avaliacao,Integer>{

	List<Avaliacao> buscarTodos();
	
	List<Avaliacao> buscarPorDescricao(String descricao);
	
	List<Avaliacao> buscarPorPeriodo(Calendar inicio, Calendar fim);
}
