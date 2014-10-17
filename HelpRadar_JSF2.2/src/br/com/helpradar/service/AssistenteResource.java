package br.com.helpradar.service;

import java.util.ArrayList;
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

import br.com.helpradar.dao.EntityManagerFactorySingleton;
import br.com.helpradar.dao.IdentificacaoDAO;
import br.com.helpradar.dao.UsuarioDAO;
import br.com.helpradar.dao.impl.IdentificacaoDAOImpl;
import br.com.helpradar.dao.impl.UsuarioDAOImpl;
import br.com.helpradar.daomessenger.DaoMessenger;
import br.com.helpradar.entity.Identificacao;
import br.com.helpradar.entity.Usuario;

import com.google.gson.Gson;


@Path("/assistente")
public class AssistenteResource {



	DaoMessenger daom = new DaoMessenger();


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarAssistentePorEspGPS/{espNome}")

	public String buscarAssistentePorEspGPS(@PathParam("espNome") String espNome){

		Map<String,List<Object[]>> mapa = 
				new HashMap<String, List<Object[]>>();
		List<Object[]> lista = daom.BuscarAssistentePorEspecialidadeGPS(espNome);
		mapa.put("Assistentes", lista);
		
		
		
		System.out.println("quantidade de assistentes achados: " + lista.size());
		//Utilizar a biblioteca do google para transformar
		//o objeto java em sua representação JSON
		return new Gson().toJson(mapa);
	}
	

	





	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/atualizarIdentificacao")
	public Response cadastrarIdentificacao(String identificacaoJSON){
		//Converter o JSON para um objeto Java
		Identificacao identificacao = 
				new Gson().fromJson(identificacaoJSON, Identificacao.class);
		//Cadastrar atraves do BO

		daom.updateIdentificacao(identificacao);

		return Response.status(201)
				.entity("identificacao (identificacao.update) atualizada").build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrarAssistente")
	public Response cadastrarAssistente(String AssistenteJSON){
		//Converter o JSON para um objeto Java
		Usuario assistente = 
				new Gson().fromJson(AssistenteJSON, Usuario.class);
		//Cadastrar atraves do BO

		daom.cadastrarAssistente(assistente);

		return Response.status(201)
				.entity("Assistente (avaliacaoDAO.update) Cadastrado").build();
	}



}



