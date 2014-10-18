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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.JSONStringer;

import br.com.helpradar.dao.EntityManagerFactorySingleton;
import br.com.helpradar.dao.IdentificacaoDAO;
import br.com.helpradar.dao.UsuarioDAO;
import br.com.helpradar.dao.impl.IdentificacaoDAOImpl;
import br.com.helpradar.dao.impl.UsuarioDAOImpl;
import br.com.helpradar.daomessenger.DaoMessenger;
import br.com.helpradar.entity.Especialidade;
import br.com.helpradar.entity.Identificacao;
import br.com.helpradar.entity.Usuario;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


@Path("/assistente")
public class AssistenteResource {



	DaoMessenger daom = new DaoMessenger();


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarAssistentePorEspGPS/{espNome}")

	public String  buscarAssistentePorEspGPS(@PathParam("espNome") String espNome){

		List<Object[]> lista = daom.BuscarAssistentePorEspecialidadeGPS(espNome);
		List<UsuarioGPS> listaGPS = new ArrayList<UsuarioGPS>();
		

		Map<String,List<UsuarioGPS>> mapa = 
				new HashMap<String, List<UsuarioGPS>>();
		
		
		for (Object[] objects : lista) {
			UsuarioGPS userGPS = new UsuarioGPS();
			userGPS.setUserId(objects[0].toString());
			userGPS.setLat((String) objects[1]);
			userGPS.setLongi((String) objects[2]);
			listaGPS.add(userGPS);
			
		}
		mapa.put("Assistentes", listaGPS);
		
		
		
		
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
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/atualizarGPS")
	public Response atualizarGPS(String GPSPlain){
		//Converter o JSON para um objeto Java
		String[] GPSslpit = GPSPlain.split(">");
		System.out.println(GPSslpit[0]);
		System.out.println(GPSslpit[1]);
		System.out.println(GPSslpit[2]);

		//daom.updateIdentificacao(identificacao);

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



