package br.com.helpradar.service;

import java.math.BigInteger;
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


@Path("/usuario")
public class UsuarioResource {
	
	DaoMessenger daom = new DaoMessenger();
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrarUsuario")
	public Response cadastrarUsuario(String usuarioJson){
		//Converter o JSON para um objeto Java
		Usuario usuario = 
				new Gson().fromJson(usuarioJson, Usuario.class);
		//Cadastrar atraves do BO

	
		daom.insertUsuario(usuario);

		return Response.status(201)
				.entity("Usuario Cadastrado").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/verificarUsuario/{userId}")

	public String verificarUsuario(@PathParam("userId") String userId){

	
		Usuario usuario = daom.searchUserByIdLong(Long.parseLong(userId));
		
	
	
		//Utilizar a biblioteca do google para transformar
		//o objeto java em sua representação JSON
		return new Gson().toJson(usuario);
	}

	
	
	
	
	
	

}
