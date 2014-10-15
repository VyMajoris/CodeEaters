package br.com.fiap.banco;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

import br.com.helpradar.daomessenger.DaoMessenger;
import br.com.helpradar.daomessenger.DaoMessenger;
import br.com.helpradar.entity.Avaliacao;
import br.com.helpradar.entity.Contato;
import br.com.helpradar.entity.Especialidade;
import br.com.helpradar.entity.Identificacao;
import br.com.helpradar.entity.TipoUsuario;
import br.com.helpradar.entity.Usuario;

public class PopulaBanco {

	static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	public static void main(String[] args) {
		
		banco();
		/*
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl(em);
		String id = "3";
		Usuario usuario = usuarioDAO.searchByIDLong(Long.parseLong(id));
		System.out.println(usuario.getNome());
		List<Long> lista = usuarioDAO.BuscarAssistentePorEspecialidadeGPS("OPERADOR");
		for (Long integer : lista) {
			System.out.println("aa");
			System.out.println(integer);
		}
		
		
		
		EspecialidadeDAO especialidadeDAO = new EspecialidadeDAOImpl(em);
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl(em);
		ContatoDAO contatoDAO = new ContatoDAOImpl(em);
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl(em);
		
		DaoMessenger daoMessenger = new DaoMessenger();
		
	
	
		
		List<Integer> listaUsuarioPorAssistenteGPS =  daoMessenger.BuscarAssistentePorEspecialidadeGPS("e");
		for (Integer usuarioInt : listaUsuarioPorAssistenteGPS) {
			System.out.println("__________________");
			System.out.println(usuarioInt);
			System.out.println(usuarioDAO.searchByID(usuarioInt).getNome());
			System.out.println("__________________");
		}

		List<Avaliacao> listaAvaliacaoPorAssistente =  usuarioDAO.buscarAvalicoesPorAssistente(2);
		for (Avaliacao avaliacao : listaAvaliacaoPorAssistente) {
		//System.out.println(avaliacao.getDescricao()); 
		}*/


	}

	private static void banco() {


		//INICIO da persistencia de 3 Avaliacoes
		Calendar c = Calendar.getInstance();


		
		

		//FIM da persistencia de 3 Avaliacoes

		//INICIO da persistencia de 3 Contato
		List<String> listEmail = new ArrayList<>();
		listEmail.add("emailUser1@gmail.com");

		List<String> listTel = new ArrayList<>();
		listTel.add("56611941");

		List<String> listEmail2 = new ArrayList<>();
		listEmail.add("emailUser2@gmail.com");

		List<String> listTel2 = new ArrayList<>();
		listTel.add("56611942");

		List<String> listTel3 = new ArrayList<>();
		listTel.add("12345673");

		List<String> listEmail3 = new ArrayList<>();
		listEmail.add("emailUser3@gmail.com");

		

		Contato contato1 = new Contato("Email1", "123456789", null, true);
		Contato contato2 = new Contato("Email2", "223456789", null, true);
		Contato contato3 = new Contato("Email3", "323456789", null, true);

		ContatoDAO contatoDAO = new ContatoDAOImpl(em);
		contatoDAO.insert(contato1);
		contatoDAO.insert(contato2);
		contatoDAO.insert(contato3);

		//FIM da persistencia de 3 Contato


		//INSERE 3 USURIOS DEFAULT
		Usuario usuario1 = new Usuario(1L, "Pedro Henrique", contato1, TipoUsuario.DEFAULT);
		

		Usuario usuario2 = new Usuario(2L, "Felipe Jose",  contato2, TipoUsuario.DEFAULT);
		

		Usuario usuario3 = new Usuario(3L, "Eduardo",  contato3, TipoUsuario.DEFAULT);



		UsuarioDAO usuarioDAO = new UsuarioDAOImpl(em);
		usuarioDAO.insert(usuario1);
		usuarioDAO.insert(usuario2);
		usuarioDAO.insert(usuario3);
		//FIM  3 USURIOS DEFAULT





		//INICIO da persistencia de 3 ASSISTENTE	
		




		//FIM da persistencia de 3 ASSISTENTE

		//INICIO da persistencia de 3 Identificacao	
		List<String> listPecas1 = new ArrayList<>();
		listPecas1.add("ListaDePecasa1");
		listPecas1.add("ListaDePecasb1");
		listPecas1.add("ListaDePecasc1");
		List<String> listPecas2 = new ArrayList<>();
		listPecas2.add("ListaDePecas2a");
		listPecas2.add("ListaDePecas2b");
		listPecas2.add("ListaDePecas2c");

		List<String> listPecas3 = new ArrayList<>();
		listPecas3.add("ListaDePecas3a");
		listPecas3.add("ListaDePecas3b");
		listPecas3.add("ListaDePecas3c");
		
		
		Identificacao identificacao1 = new Identificacao( listPecas1);
		Identificacao identificacao2 = new Identificacao( listPecas2);
		Identificacao identificacao3 = new Identificacao( listPecas3);

		IdentificacaoDAO identificacaoDAO = new IdentificacaoDAOImpl(em);
		identificacaoDAO.insert(identificacao1);
		identificacaoDAO.insert(identificacao2);
		identificacaoDAO.insert(identificacao3);
		//FIM da persistencia de 3 Identificacao

		
		
		

		Especialidade especialidade1 = new Especialidade("Encanador");
		Especialidade especialidade2 = new Especialidade("Mecanico");
		Especialidade especialidade3 = new Especialidade("Programador");

		EspecialidadeDAO especialidadeDAO = new EspecialidadeDAOImpl(em);
		especialidadeDAO.insert(especialidade1);
		especialidadeDAO.insert(especialidade2);
		especialidadeDAO.insert(especialidade3);


	

		
		Especialidade especialidade4 = new Especialidade("4Especialidade");
		Especialidade especialidade5 = new Especialidade("5Especialidade");
		Especialidade especialidade6 = new Especialidade("OPERADOR");
		
		especialidadeDAO.insert(especialidade4);
		especialidadeDAO.insert(especialidade5);
		especialidadeDAO.insert(especialidade6);
				




		Avaliacao avaliacao1 = new Avaliacao(null,"Marravira",c,"Curso de culinária",5);
		Avaliacao avaliacao2 = new Avaliacao(null,"Era melhor ter visto o filme do Pelé",c,"Carreto",1);
		Avaliacao avaliacao3 = new Avaliacao(null,"Fatou picar atrás", c, "Corte de Cabelo Gaúcho", 3);
		
		Avaliacao avaliacao4 = new Avaliacao(null,"Sem graça",c,"Palhaço",1);
		Avaliacao avaliacao5 = new Avaliacao(null,"Coitado, programar em uma linguagem retardada e para um sistema retardado é complicado",c,"App IOS",3);
		Avaliacao avaliacao6 = new Avaliacao(null,"Achei uma merda", c, "Desentupimento de vaso sanitário", 5);
		
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl(em);
		avaliacaoDAO.insert(avaliacao1);
		avaliacaoDAO.insert(avaliacao2);
		avaliacaoDAO.insert(avaliacao3);
		avaliacaoDAO.insert(avaliacao4);
		avaliacaoDAO.insert(avaliacao5);
		avaliacaoDAO.insert(avaliacao6);
		
		
		
		
		usuario2.setTipoUsuario(TipoUsuario.ASSISTENTE);
		
		usuario2.setIdentificacao(identificacao2);
		usuario2.getAvaliacao().add(avaliacao1);
		usuario2.getAvaliacao().add(avaliacao2);
		usuario2.getAvaliacao().add(avaliacao3);
		usuario2.getEspecialidade().add(especialidade1);
		usuario2.getEspecialidade().add(especialidade2);
		usuario2.getEspecialidade().add(especialidade3);
		usuario2.getEspecialidade().add(especialidade4);
		usuarioDAO.update(usuario2);

		usuario3.setTipoUsuario(TipoUsuario.ASSISTENTE);
		
		usuario3.setIdentificacao(identificacao3);
		usuario3.getAvaliacao().add(avaliacao4);
		usuario3.getAvaliacao().add(avaliacao5);
		usuario3.getAvaliacao().add(avaliacao6);
		usuario3.getEspecialidade().add(especialidade4);
		usuario3.getEspecialidade().add(especialidade5);
		usuario3.getEspecialidade().add(especialidade6);
		usuarioDAO.update(usuario3);

		
	}

}
