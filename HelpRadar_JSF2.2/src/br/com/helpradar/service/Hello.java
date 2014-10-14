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

import com.google.gson.Gson;

import br.com.helpradar.dao.EntityManagerFactorySingleton;
import br.com.helpradar.dao.EspecialidadeDAO;
import br.com.helpradar.dao.impl.EspecialidadeDAOImpl;
import br.com.helpradar.daomessenger.DaoMessenger;
import br.com.helpradar.daomessenger.DaoMessenger;
import br.com.helpradar.entity.Especialidade;

@Path("/hello")
public class Hello {
	DaoMessenger daom = new DaoMessenger();
	EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	EspecialidadeDAO especialidadeDAO = new EspecialidadeDAOImpl(em);
	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {

		daom.BuscarAssistentePorEspecialidadeGPS("e");

		return "Hello Jersey";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarEspecialidade/{nome}")
	public String getEspecialidades(@PathParam("nome") String nome){



		List<Integer> listaUsuarioPorAssistenteGPS = daom.BuscarAssistentePorEspecialidadeGPS(nome);
		Map<String,List<Integer>> mapa = new HashMap<>();

		mapa.put("especialidades", listaUsuarioPorAssistenteGPS);
		for (int i = 0; i < listaUsuarioPorAssistenteGPS.size(); i++) {
			System.out.println("***"+listaUsuarioPorAssistenteGPS.get(i));		
		}

		System.out.println("Nome de especialidade requisitada: " + nome);
		//Utilizar a biblioteca do google para transformar
		//o objeto java em sua representação JSON
		return new Gson().toJson(mapa);
	}











	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		DaoMessenger daom = new DaoMessenger();
		daom.BuscarAssistentePorEspecialidadeGPS("e");
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		DaoMessenger daom = new DaoMessenger();
		daom.BuscarAssistentePorEspecialidadeGPS("e");
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
		+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}

} 