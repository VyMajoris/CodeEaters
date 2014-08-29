package br.com.fiap.pacote.dao;

import java.util.List;

import br.com.fiap.dao.DAO;
import br.com.fiap.pacote.entity.Reserva;

public interface ReservaDAO extends DAO<Reserva,Integer>{

	List<Reserva> buscaPorNomeCliente(String nome);
	
	List<Reserva> buscarTodos();
}
