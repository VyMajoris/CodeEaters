package br.com.helpradar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.helpradar.dao.AvaliacaoDAO;
import br.com.helpradar.dao.EntityManagerFactorySingleton;
import br.com.helpradar.dao.UsuarioDAO;
import br.com.helpradar.dao.impl.AvaliacaoDAOImpl;
import br.com.helpradar.dao.impl.UsuarioDAOImpl;
import br.com.helpradar.entity.Avaliacao;
import br.com.helpradar.entity.Usuario;

import com.google.gson.Gson;

@Path("/avaliacao")
public class AvaliacaoResource {

	
	EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	UsuarioDAO usuarioDAO = new UsuarioDAOImpl(em);
	AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl(em);
	
	/**
	 * @param assistID
	 * @return
	 * Retorna as ultimas 10 avaliações do asissistente
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarAvaliacaoPorAssist/{assistID}")
	public String getAvavaliacoes(@PathParam("assistID") int assistID){
		
		
		Map<String,List<Avaliacao>> mapa = 
				new HashMap<String, List<Avaliacao>>();
		
		List<Avaliacao> lista= usuarioDAO.buscarAvalicoesPorAssistente(assistID);
		
		
		mapa.put("avaliacoes", lista);
		

		System.out.println("Buscando avaliacoes do id: " + assistID);
		//Utilizar a biblioteca do google para transformar
		//o objeto java em sua representação JSON
		return new Gson().toJson(mapa);
	}

	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrarAvaliacao")
	public Response cadastrarAvaliacao(String avaliacaoJSON){
		//Converter o JSON para um objeto Java
		Avaliacao avaliacao = 
				new Gson().fromJson(avaliacaoJSON, Avaliacao.class);
		//Cadastrar atraves do BO
		
		avaliacaoDAO.insert(avaliacao);
		
		return Response.status(201)
						.entity("avaliacao (avaliacaoDAO.update) Cadastrado").build();
	}
	
}



