package br.com.helpradar.dao;

import java.util.List;

import br.com.helpradar.entity.Especialidade;

public interface EspecialidadeDAO extends DAO<Especialidade,Integer>{

	List<Especialidade> buscaPorNome(String nome);
	
	List<Especialidade> buscarTodos();

	List<String> buscarTodosNomes();
}
