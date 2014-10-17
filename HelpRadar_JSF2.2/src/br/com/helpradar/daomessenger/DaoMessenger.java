package br.com.helpradar.daomessenger;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import sun.security.util.BigInt;
import br.com.helpradar.dao.AvaliacaoDAO;

import br.com.helpradar.dao.EntityManagerFactorySingleton;
import br.com.helpradar.dao.EspecialidadeDAO;
import br.com.helpradar.dao.IdentificacaoDAO;
import br.com.helpradar.dao.UsuarioDAO;
import br.com.helpradar.dao.impl.AvaliacaoDAOImpl;

import br.com.helpradar.dao.impl.EspecialidadeDAOImpl;
import br.com.helpradar.dao.impl.IdentificacaoDAOImpl;
import br.com.helpradar.dao.impl.UsuarioDAOImpl;
import br.com.helpradar.entity.Identificacao;
import br.com.helpradar.entity.Usuario;


public class DaoMessenger {

	EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	EspecialidadeDAO especialidadeDAO = new EspecialidadeDAOImpl(em);
	AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl(em);
	IdentificacaoDAO identificacaoDAO = new IdentificacaoDAOImpl(em);

	UsuarioDAO usuarioDAO = new UsuarioDAOImpl(em);





	public   List<Usuario> BuscarAssistentePorEspecialidadeGPS(String espNome){
		System.out.println("testeee");
		List<Usuario> listaUsuarioGPS = usuarioDAO.BuscarAssistentePorEspecialidadeGPS(espNome);
		for (int i = 0; i < listaUsuarioGPS.size(); i++) {
			System.out.println(listaUsuarioGPS.get(i).toString());
		}
		return listaUsuarioGPS;

	}
	

	public Usuario searchUserByIdLong(Long  userId){
		return usuarioDAO.searchByIDLong(userId);
	}
	
	public void insertUsuario(Usuario usuario){
		 usuarioDAO.insert(usuario);
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

	public   String cadastrarAssistente(Usuario assistente){
		try {
			usuarioDAO.update(assistente);
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro!";
		}


		return null;
	}


}
