package br.com.helpradar.daomessenger;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import br.com.helpradar.dao.AvaliacaoDAO;
import br.com.helpradar.dao.ContatoDAO;
import br.com.helpradar.dao.EntityManagerFactorySingleton;
import br.com.helpradar.dao.EspecialidadeDAO;
import br.com.helpradar.dao.IdentificacaoDAO;
import br.com.helpradar.dao.UsuarioDAO;
import br.com.helpradar.dao.impl.AvaliacaoDAOImpl;
import br.com.helpradar.dao.impl.ContatoDAOImpl;
import br.com.helpradar.dao.impl.EspecialidadeDAOImpl;
import br.com.helpradar.dao.impl.IdentificacaoDAOImpl;
import br.com.helpradar.dao.impl.UsuarioDAOImpl;
import br.com.helpradar.entity.Identificacao;
import br.com.helpradar.entity.Usuario;


public class DaoMessenger {

	EspecialidadeDAO especialidadeDAO;
	AvaliacaoDAO avaliacaoDAO ;
	IdentificacaoDAO identificacaoDAO ;
	ContatoDAO contatoDAO;
	UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());

	



	public  List<Integer> BuscarAssistentePorEspecialidadeGPS(String espNome){

		List<Integer> lista = usuarioDAO.BuscarAssistentePorEspecialidadeGPS(espNome);
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).toString());
		}
		return lista;

	}

	/*	public  Usuario searchById(Integer assistId){
		return usuarioDAO.searchByID(assistId);
	}

	public  String updateIdentificacao(Identificacao identificacao){
		try {
			identificacaoDAO.update(identificacao);
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro!";
		}


		return null;
	}

	public  String cadastrarAssistente(Usuario assistente){
		try {
			usuarioDAO.update(assistente);
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro!";
		}


		return null;
	}
	 */

}
