package br.com.fiap.banco;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.helpradar.dao.AssistenteDAO;
import br.com.helpradar.dao.AvaliacaoDAO;
import br.com.helpradar.dao.ContatoDAO;
import br.com.helpradar.dao.EntityManagerFactorySingleton;
import br.com.helpradar.dao.EspecialidadeDAO;
import br.com.helpradar.dao.IdentificacaoDAO;
import br.com.helpradar.dao.UsuarioDAO;
import br.com.helpradar.dao.impl.AssistenteDAOImpl;
import br.com.helpradar.dao.impl.AvaliacaoDAOImpl;
import br.com.helpradar.dao.impl.ContatoDAOImpl;
import br.com.helpradar.dao.impl.EspecialidadeDAOImpl;
import br.com.helpradar.dao.impl.IdentificacaoDAOImpl;
import br.com.helpradar.dao.impl.UsuarioDAOImpl;
import br.com.helpradar.entity.Assistente;
import br.com.helpradar.entity.Avaliacao;
import br.com.helpradar.entity.Contato;
import br.com.helpradar.entity.Especialidade;
import br.com.helpradar.entity.Identificacao;
import br.com.helpradar.entity.Usuario;

public class PopulaBanco {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		
		 //INICIO da persistencia de 3 especialidades 
		 
		Especialidade especialidade1 = new Especialidade("Encanador");
		Especialidade especialidade2 = new Especialidade("Mecanico");
		Especialidade especialidade3 = new Especialidade("Programador");
		
		EspecialidadeDAO especialidadeDAO = new EspecialidadeDAOImpl(em);
		especialidadeDAO.insert(especialidade1);
		especialidadeDAO.insert(especialidade2);
		especialidadeDAO.insert(especialidade3);
		
		//FIM da persistencia das 3 especialidades
	
		
		
		//INICIO da persistencia de 3 Avaliacoes
		Calendar c = Calendar.getInstance();
		
		
		Avaliacao avaliacao1 = new Avaliacao("Muito Bom", c, "Titulo1", 5);
		Avaliacao avaliacao2 = new Avaliacao("Bom", c, "Titulo2", 3 );
		Avaliacao avaliacao3 = new Avaliacao("Sem avaliacao", c, "Titulo3", null);
		
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAOImpl(em);
		avaliacaoDAO.insert(avaliacao1);
		avaliacaoDAO.insert(avaliacao2);
		avaliacaoDAO.insert(avaliacao3);
		
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
		
		
		Contato contato1 = new Contato(listEmail, listTel, null, true);
		Contato contato2 = new Contato(listEmail2, listTel2, null, true);
		Contato contato3 = new Contato(listEmail3, listTel3, null, true);
		
		ContatoDAO contatoDAO = new ContatoDAOImpl(em);
		contatoDAO.insert(contato1);
		contatoDAO.insert(contato2);
		contatoDAO.insert(contato3);
		
		//FIM da persistencia de 3 Contato
		
		
		//INICIO da persistencia de 3 Usuario	
		Usuario usuario1 = new Usuario(1, "Pedro Henrique", false, null, contato1, null);
		List<Usuario> listAmg2 = new ArrayList<>();
		listAmg2.add(usuario1);
		
		Usuario usuario2 = new Usuario(2, "Felipe Jose", false, listAmg2, contato2, null);
		List<Usuario> listAmg3 = new ArrayList<>();
		listAmg3.add(usuario2);

		Usuario usuario3 = new Usuario(3, "Eduardo",false, listAmg3, contato3, null);
		
				
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl(em);
		usuarioDAO.insert(usuario1);
		usuarioDAO.insert(usuario2);
		usuarioDAO.insert(usuario3);
		//FIM da persistencia de 3 Usuario
		
		
		//INICIO da persistencia de 3 ASSISTENTE	
		List<Avaliacao> listAvaiacao = new ArrayList<>();
		listAvaiacao.add(avaliacao1);
		
		List<Avaliacao> listAvaiacao2 = new ArrayList<>();
		listAvaiacao2.add(avaliacao2);
		
		List<Avaliacao> listAvaiacao3 = new ArrayList<>();
		listAvaiacao3.add(avaliacao3);
		
		
		
		Assistente assistente1 = new Assistente(1, false, null, listAvaiacao, usuario1);
		Assistente assistente2 = new Assistente(1, false, null, listAvaiacao2, usuario3);
		Assistente assistente3 = new Assistente(1, false, null, listAvaiacao3, usuario2);
		
		AssistenteDAO assistenteDAO = new AssistenteDAOImpl(em);
		assistenteDAO.insert(assistente1);
		assistenteDAO.insert(assistente2);
		assistenteDAO.insert(assistente3);
		//FIM da persistencia de 3 ASSISTENTE
		
		//INICIO da persistencia de 3 Identificacao	
		List<String> listPecas1 = new ArrayList<>();
		listPecas1.add("ListaDePecas1?");
				
		List<String> listPecas2 = new ArrayList<>();
		listPecas2.add("ListaDePecas2?");
		
		List<String> listPecas3 = new ArrayList<>();
		listPecas3.add("ListaDePecas3?");
		
		Identificacao identificacao1 = new Identificacao(assistente1, listPecas1);
		Identificacao identificacao2 = new Identificacao(assistente2, listPecas2);
		Identificacao identificacao3 = new Identificacao(assistente3, listPecas3);
				
		IdentificacaoDAO identificacaoDAO = new IdentificacaoDAOImpl(em);
		identificacaoDAO.insert(identificacao1);
		identificacaoDAO.insert(identificacao2);
		identificacaoDAO.insert(identificacao3);
		//FIM da persistencia de 3 Identificacao
		
		
		
		
//		//INICIO da persistencia de 3 Identificacao	3
//		List<String> listPecas = new ArrayList<>();
//		listPecas.add("roupa roxa");
//		
//		List<String> listPecas21 = new ArrayList<>();
//		listPecas21.add("roupa preta");
//		
//		List<String> listPecas31 = new ArrayList<>();
//		listPecas31.add("roupa rosa");
//		
//		Identificacao ident1 = new Identificacao(1, assistente1, listPecas1);
//		Identificacao ident2 = new Identificacao(2, assistente2, listPecas21);
//		Identificacao ident3 = new Identificacao(3, assistente3, listPecas31);
//								
//		IdentificacaoDAO identDAO = new IdentificacaoDAOImpl(em);
//		identDAO.insert(ident1);
//		identDAO.insert(ident2);
//		identDAO.insert(ident3);
//		//FIM da persistencia de 3 Identificacao
//		
		
		
		
		
		
		
		
//		
//		/**
//		 * INICIO da persistencia de pacotes de viagens
//		 */
//		//Cria o primeiro pacote, com data de saida para 23/09/2013 e transporte1 = GOL (vide acima)
//		Calendar dtSaida1 = Calendar.getInstance();
//		dtSaida1.set(2013, 8, 23);
//		Pacote pacote1 = new Pacote("Porto de Galinhas", dtSaida1, 7, 2000, transporte1);
//		
//		//Cria o segundo pacote, com data de saida para 20/05/2013 e transporte1 = GOL (vide acima)
//		Calendar dtSaida2 = Calendar.getInstance();
//		dtSaida2.set(2013, 4, 20);
//		Pacote pacote2 = new Pacote("Natal", dtSaida2, 10, 2300, transporte1);
//		
//		//Cria o terceiro pacote, com data de saida para 13/06/2013 e transporte2 = COMETA (vide acima)
//		Calendar dtSaida3 = Calendar.getInstance();
//		dtSaida3.set(2013, 6, 13);
//		Pacote pacote3 = new Pacote("Bonito", dtSaida3, 8, 500, transporte2);
//		
//		//Cria o quarto pacote, com data de saida para 01/12/2013 e transporte3 = MSC Cruzeiros (vide acima)
//		Calendar dtSaida4 = Calendar.getInstance();
//		dtSaida4.set(2013, 8, 23);
//		Pacote pacote4 = new Pacote("Cancun", dtSaida4, 10, 6000, transporte3);
//		
//		//Persiste todos os pacotes
//		PacoteDAO pacoteDAO = new PacoteDAOImpl(em);
//		pacoteDAO.insert(pacote1);
//		pacoteDAO.insert(pacote2);
//		pacoteDAO.insert(pacote3);
//		pacoteDAO.insert(pacote4);
//		/**
//		 * FIM da persistencia de pacotes de viagens
//		 */
//		
//		/**
//		 * INICIO persistencia de clientes e endereços
//		 */
//		//Cria um cliente com endereço, data de nascimento 19/08/1983 e lista de pacotes com pacotes 1 e 2
//		Endereco end1 = new Endereco("Rua Lins de Vasconcelos", 12898999, cidade2);
//		Calendar dtNasc1 = Calendar.getInstance();
//		dtNasc1.set(1983, 7, 19);
//		List<Pacote> listPac1 = new ArrayList<>();
//		listPac1.add(pacote1);
//		listPac1.add(pacote2);
//		Cliente cliente1 = new Cliente("Thiago", "98728018736", dtNasc1, end1,  listPac1);
//		
//		//Cria um cliente com endereço, data de nascimento 02/02/1990 e lista de pacotes com pacotes 1 e 4
//		Endereco end2 = new Endereco("Rua Duque de Caxias, 2-90", 17017519, cidade1);
//		Calendar dtNasc2 = Calendar.getInstance();
//		dtNasc2.set(1990, 1, 2);
//		List<Pacote> listPac2 = new ArrayList<>();
//		listPac2.add(pacote1);
//		listPac2.add(pacote4);
//		Cliente cliente2 = new Cliente("Leandro", "50293494030", dtNasc2, end2,  listPac2);
//		
//		//Cria um cliente com endereço, data de nascimento 24/02/1999 e lista de pacotes com pacotes 2, 3 e 4
//		Endereco end3 = new Endereco("Rua 23 de janeiro, 900", 12892309, cidade3);
//		Calendar dtNasc3 = Calendar.getInstance();
//		dtNasc3.set(1999, 1, 24);
//		List<Pacote> listPac3 = new ArrayList<>();
//		listPac3.add(pacote2);
//		listPac3.add(pacote3);
//		listPac3.add(pacote4);
//		Cliente cliente3 = new Cliente("Maria", "99828771111", dtNasc3, end3,  listPac3);
//		
//		//Cria um cliente com endereço, data de nascimento 19/01/2000, lista de pacotes com pacote 1 e reserva
//		Endereco end4 = new Endereco("Av otavio 322", 12220999, cidade3);
//		Calendar dtNasc4 = Calendar.getInstance();
//		dtNasc4.set(2000, 0, 19);
//		List<Pacote> listPac4 = new ArrayList<>();
//		listPac4.add(pacote1);
//		Cliente cliente4 = new Cliente("João", "90028383848", dtNasc4, end4, listPac4);
//		
//		//Cria um cliente com endereço, data de nascimento 19/08/1083 e lista de pacotes com pacotes 1, 2, 3 e 4
//		Endereco end5 = new Endereco("Rua Lins de Vasconcelos", 12890000, cidade1);
//		Calendar dtNasc5 = Calendar.getInstance();
//		dtNasc5.set(1983, 7, 19);
//		List<Pacote> listPac5 = new ArrayList<>();
//		listPac5.add(pacote1);
//		listPac5.add(pacote2);
//		listPac5.add(pacote3);
//		listPac5.add(pacote4);
//		Cliente cliente5 = new Cliente("Julio", "88892992922", dtNasc5, end5,  listPac5);
//		
//		ClienteDAO clienteDAO = new ClienteDAOImpl(em);
//		clienteDAO.insert(cliente1);
//		clienteDAO.insert(cliente2);
//		clienteDAO.insert(cliente3);
//		clienteDAO.insert(cliente4);
//		clienteDAO.insert(cliente5);
//		
//		/**
//		 * FIM persistencia de clientes
//		 */
//		
//		/**
//		 * INICIO Persistencia de reservas
//		 */
//		Calendar dtReseva1 = Calendar.getInstance();
//		dtReseva1.set(2013, 3, 3);
//		Reserva reserva1 = new Reserva(10,dtReseva1,pacote1,cliente2);
//		
//		Calendar dtReseva2 = Calendar.getInstance();
//		dtReseva2.set(2013, 2, 20);
//		Reserva reserva2 = new Reserva(10,dtReseva2,pacote4,cliente5);
//		
//		ReservaDAO reservaDao = new ReservaDAOImpl(em);
//		reservaDao.insert(reserva1);
//		reservaDao.insert(reserva2);
//		/**
//		 * FIM Persistencia de reservas
//		 */
		
	}

}
