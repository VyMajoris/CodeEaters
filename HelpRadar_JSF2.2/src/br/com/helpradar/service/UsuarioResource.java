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
import br.com.helpradar.entity.Avaliacao;
import br.com.helpradar.entity.Especialidade;
import br.com.helpradar.entity.Identificacao;
import br.com.helpradar.entity.TipoUsuario;
import br.com.helpradar.entity.Usuario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Path("/usuario")
public class UsuarioResource {
	
	DaoMessenger daom = new DaoMessenger();
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrarUsuario")
	public Response cadastrarUsuario(String usuarioJson){
		//Converter o JSON para um objeto Java
		
		System.out.println(usuarioJson);
		
		
		Usuario usuario = 
				new Gson().fromJson(usuarioJson, Usuario.class);
		//Cadastrar atraves do BO
		System.out.println(usuario.getUserId());
		System.out.println(usuario.getNome());
		daom.insertUsuario(usuario);

		return Response.status(201)
				.entity("Usuario Cadastrado").build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/verificarUsuario/{userId}")

	public String verificarUsuario(@PathParam("userId") String userId){
		System.out.println("verificarUsuario");
	
		Usuario usuario = daom.searchUserByIdLong(Long.parseLong(userId));
		
		if (usuario != null) {
			System.out.println(usuario.getUserId() +"-"+usuario.getTipoUsuario());
			return usuario.getUserId() +"-"+usuario.getTipoUsuario();
		}else{
			System.out.println("NÃO CADASTRADO");
			return "";
		}
		
		
		
		
	
		
		//SAPORRA NÃO FUNCIONA
	/*	Gson gson = new GsonBuilder()
        .registerTypeAdapter(Usuario.class, new MyTypeAdapter<Especialidade>())
        .registerTypeAdapter(Usuario.class, new MyTypeAdapter<Avaliacao>())
        .enableComplexMapKeySerialization()
        .create();
		System.out.println(usuario);
		
		
		
		return  gson.toJson(usuario);
		*/
		
	}

	
	
	
	
	
	

}
