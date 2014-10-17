package br.com.helpradar.dao;

import java.util.List;

import br.com.helpradar.entity.Avaliacao;
import br.com.helpradar.entity.Identificacao;
import br.com.helpradar.entity.Usuario;

public interface UsuarioDAO extends DAO<Usuario,Integer>{



	

	List<Avaliacao> buscarAvalicoesPorAssistente(int assistId);

	Identificacao buscarIdentificacaoPorAssistente(int assistId);

	List<Usuario> BuscarAssistentePorEspecialidade(int espID);

	/**
	 * @param espID
	 * @return ID , lat, long<br>
	 * Use esse método mostrar os assistentes no mapa
	 */
	List<Usuario> BuscarAssistentePorEspecialidadeGPS(String espNome);

	Usuario searchByIDLong(Long userId);

	
}
