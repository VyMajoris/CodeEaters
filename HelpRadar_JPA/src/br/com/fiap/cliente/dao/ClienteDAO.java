package br.com.fiap.cliente.dao;

import java.util.List;

import br.com.fiap.cliente.entity.Cliente;
import br.com.fiap.dao.DAO;

public interface ClienteDAO extends DAO<Cliente,Integer>{

	List<Cliente> buscarTodos();

	List<Cliente> buscarPorNome(String nome);
	
	List<String> buscarNome(String nome);
	
}
