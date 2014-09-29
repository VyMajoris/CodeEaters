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

import br.com.helpradar.dao.EntityManagerFactorySingleton;
import br.com.helpradar.dao.EspecialidadeDAO;
import br.com.helpradar.dao.impl.EspecialidadeDAOImpl;
import br.com.helpradar.entity.Especialidade;

import com.google.gson.Gson;

@Path("/especialidade")
public class EspecialidadeResource {

	
	EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	EspecialidadeDAO especialidadeDAO = new EspecialidadeDAOImpl(em);
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarEspecialidade/{nome}")
	public String getEspecialidades(@PathParam("nome") String nome){
		
		
		Map<String,List<Especialidade>> mapa = 
				new HashMap<String, List<Especialidade>>();
		
		List<Especialidade> lista= especialidadeDAO.buscaPorNome(nome);
		
		mapa.put("especialidades", lista);
		

		System.out.println("Nome de especialidade requisitada: " + nome);
		//Utilizar a biblioteca do google para transformar
		//o objeto java em sua representação JSON
		return new Gson().toJson(mapa);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrarEspecialidade")
	public Response cadastrarEspecialidade(String especialidadeJSON){
		//Converter o JSON para um objeto Java
		Especialidade especialidade = 
				new Gson().fromJson(especialidadeJSON, Especialidade.class);
		//Cadastrar atraves do BO
		
		especialidadeDAO.insert(especialidade);
		
		return Response.status(201)
						.entity("Especialidade Cadastrado").build();
	}
	
}



