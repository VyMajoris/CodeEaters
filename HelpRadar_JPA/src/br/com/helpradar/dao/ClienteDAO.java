package br.com.helpradar.dao;

import java.util.List;

import br.com.helpradar.entity.Identificacao;

public interface ClienteDAO extends DAO<Identificacao,Integer>{

	List<Identificacao> buscarTodos();

	List<Identificacao> buscarPorNome(String nome);
	
	List<String> buscarNome(String nome);
	
}
