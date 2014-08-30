package br.com.fiap.banco;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.pacote.dao.PacoteDAO;
import br.com.fiap.pacote.dao.ReservaDAO;
import br.com.fiap.pacote.dao.TransporteDAO;
import br.com.fiap.pacote.dao.impl.PacoteDAOImpl;
import br.com.fiap.pacote.dao.impl.ReservaDAOImpl;
import br.com.fiap.pacote.dao.impl.TransporteDAOImpl;
import br.com.helpradar.dao.ClienteDAO;
import br.com.helpradar.dao.EntityManagerFactorySingleton;
import br.com.helpradar.dao.UsuarioDAO;
import br.com.helpradar.dao.impl.CidadeDAOImpl;
import br.com.helpradar.dao.impl.IdentificacaoDAOImpl;
import br.com.helpradar.entity.Assistente;
import br.com.helpradar.entity.Avaliacao;
import br.com.helpradar.entity.Especialidade;
import br.com.helpradar.entity.Identificacao;
import br.com.helpradar.entity.Tags;
import br.com.helpradar.entity.Usuario;



//TESTE GITHUB
public class PopulaBanco {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		/**
		 * INICIO da persistencia de 3 cidades 
		 */
		Usuario cidade1 = new Usuario("Londrina", "PR", 14, 350);
		Usuario cidade2 = new Usuario("São Paulo", "SP", 11, 11000);
		Usuario cidade3 = new Usuario("Salvador", "BA", 19, 1080);
		
		UsuarioDAO cidadeDAO = new CidadeDAOImpl(em);
		cidadeDAO.insert(cidade1);
		cidadeDAO.insert(cidade2);
		cidadeDAO.insert(cidade3);
		/**
		 * FIM da persistencia das 3 cidades 
		 */
		
		
		/**
		 * INICIO da persistencia de transporte
		 */
		Tags transporte1 = new Tags("GOL");
		Tags transporte2 = new Tags("COMETA");
		Tags transporte3 = new Tags("MSC Cruzeiros");
		
		TransporteDAO transporteDAO = new TransporteDAOImpl(em);
		transporteDAO.insert(transporte1);
		transporteDAO.insert(transporte2);
		transporteDAO.insert(transporte3);
		/**
		 * FIM da persistencia de transporte 
		 */
		
		
		/**
		 * INICIO da persistencia de pacotes de viagens
		 */
		//Cria o primeiro pacote, com data de saida para 23/09/2013 e transporte1 = GOL (vide acima)
		Calendar dtSaida1 = Calendar.getInstance();
		dtSaida1.set(2013, 8, 23);
		Avaliacao pacote1 = new Avaliacao("Porto de Galinhas", dtSaida1, 7, 2000, transporte1);
		
		//Cria o segundo pacote, com data de saida para 20/05/2013 e transporte1 = GOL (vide acima)
		Calendar dtSaida2 = Calendar.getInstance();
		dtSaida2.set(2013, 4, 20);
		Avaliacao pacote2 = new Avaliacao("Natal", dtSaida2, 10, 2300, transporte1);
		
		//Cria o terceiro pacote, com data de saida para 13/06/2013 e transporte2 = COMETA (vide acima)
		Calendar dtSaida3 = Calendar.getInstance();
		dtSaida3.set(2013, 6, 13);
		Avaliacao pacote3 = new Avaliacao("Bonito", dtSaida3, 8, 500, transporte2);
		
		//Cria o quarto pacote, com data de saida para 01/12/2013 e transporte3 = MSC Cruzeiros (vide acima)
		Calendar dtSaida4 = Calendar.getInstance();
		dtSaida4.set(2013, 8, 23);
		Avaliacao pacote4 = new Avaliacao("Cancun", dtSaida4, 10, 6000, transporte3);
		
		//Persiste todos os pacotes
		PacoteDAO pacoteDAO = new PacoteDAOImpl(em);
		pacoteDAO.insert(pacote1);
		pacoteDAO.insert(pacote2);
		pacoteDAO.insert(pacote3);
		pacoteDAO.insert(pacote4);
		/**
		 * FIM da persistencia de pacotes de viagens
		 */
		
		/**
		 * INICIO persistencia de clientes e endereços
		 */
		//Cria um cliente com endereço, data de nascimento 19/08/1983 e lista de pacotes com pacotes 1 e 2
		Assistente end1 = new Assistente("Rua Lins de Vasconcelos", 12898999, cidade2);
		Calendar dtNasc1 = Calendar.getInstance();
		dtNasc1.set(1983, 7, 19);
		List<Avaliacao> listPac1 = new ArrayList<>();
		listPac1.add(pacote1);
		listPac1.add(pacote2);
		Identificacao cliente1 = new Identificacao("Thiago", "98728018736", dtNasc1, end1,  listPac1);
		
		//Cria um cliente com endereço, data de nascimento 02/02/1990 e lista de pacotes com pacotes 1 e 4
		Assistente end2 = new Assistente("Rua Duque de Caxias, 2-90", 17017519, cidade1);
		Calendar dtNasc2 = Calendar.getInstance();
		dtNasc2.set(1990, 1, 2);
		List<Avaliacao> listPac2 = new ArrayList<>();
		listPac2.add(pacote1);
		listPac2.add(pacote4);
		Identificacao cliente2 = new Identificacao("Leandro", "50293494030", dtNasc2, end2,  listPac2);
		
		//Cria um cliente com endereço, data de nascimento 24/02/1999 e lista de pacotes com pacotes 2, 3 e 4
		Assistente end3 = new Assistente("Rua 23 de janeiro, 900", 12892309, cidade3);
		Calendar dtNasc3 = Calendar.getInstance();
		dtNasc3.set(1999, 1, 24);
		List<Avaliacao> listPac3 = new ArrayList<>();
		listPac3.add(pacote2);
		listPac3.add(pacote3);
		listPac3.add(pacote4);
		Identificacao cliente3 = new Identificacao("Maria", "99828771111", dtNasc3, end3,  listPac3);
		
		//Cria um cliente com endereço, data de nascimento 19/01/2000, lista de pacotes com pacote 1 e reserva
		Assistente end4 = new Assistente("Av otavio 322", 12220999, cidade3);
		Calendar dtNasc4 = Calendar.getInstance();
		dtNasc4.set(2000, 0, 19);
		List<Avaliacao> listPac4 = new ArrayList<>();
		listPac4.add(pacote1);
		Identificacao cliente4 = new Identificacao("João", "90028383848", dtNasc4, end4, listPac4);
		
		//Cria um cliente com endereço, data de nascimento 19/08/1083 e lista de pacotes com pacotes 1, 2, 3 e 4
		Assistente end5 = new Assistente("Rua Lins de Vasconcelos", 12890000, cidade1);
		Calendar dtNasc5 = Calendar.getInstance();
		dtNasc5.set(1983, 7, 19);
		List<Avaliacao> listPac5 = new ArrayList<>();
		listPac5.add(pacote1);
		listPac5.add(pacote2);
		listPac5.add(pacote3);
		listPac5.add(pacote4);
		Identificacao cliente5 = new Identificacao("Julio", "88892992922", dtNasc5, end5,  listPac5);
		
		ClienteDAO clienteDAO = new IdentificacaoDAOImpl(em);
		clienteDAO.insert(cliente1);
		clienteDAO.insert(cliente2);
		clienteDAO.insert(cliente3);
		clienteDAO.insert(cliente4);
		clienteDAO.insert(cliente5);
		
		/**
		 * FIM persistencia de clientes
		 */
		
		/**
		 * INICIO Persistencia de reservas
		 */
		Calendar dtReseva1 = Calendar.getInstance();
		dtReseva1.set(2013, 3, 3);
		Especialidade reserva1 = new Especialidade(10,dtReseva1,pacote1,cliente2);
		
		Calendar dtReseva2 = Calendar.getInstance();
		dtReseva2.set(2013, 2, 20);
		Especialidade reserva2 = new Especialidade(10,dtReseva2,pacote4,cliente5);
		
		ReservaDAO reservaDao = new ReservaDAOImpl(em);
		reservaDao.insert(reserva1);
		reservaDao.insert(reserva2);
		/**
		 * FIM Persistencia de reservas
		 */
		
	}

}
