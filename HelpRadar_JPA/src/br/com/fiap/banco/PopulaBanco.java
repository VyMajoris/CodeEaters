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
import br.com.helpradar.entity.Avaliacao;
import br.com.helpradar.entity.Contato;
import br.com.helpradar.entity.Especialidade;
import br.com.helpradar.entity.Identificacao;
import br.com.helpradar.entity.TipoUsuario;
import br.com.helpradar.entity.Usuario;

public class PopulaBanco {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();




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


		//INSERE 3 USURIOS DEFAULT
		Usuario usuario1 = new Usuario(1, "Pedro Henrique", false, null, contato1, TipoUsuario.DEFAULT);
		List<Usuario> listAmg2 = new ArrayList<>();
		listAmg2.add(usuario1);

		Usuario usuario2 = new Usuario(2, "Felipe Jose", false, listAmg2, contato2, TipoUsuario.DEFAULT);
		List<Usuario> listAmg3 = new ArrayList<>();
		listAmg3.add(usuario2);

		Usuario usuario3 = new Usuario(3, "Eduardo",false, listAmg3, contato3, TipoUsuario.DEFAULT);



		UsuarioDAO usuarioDAO = new UsuarioDAOImpl(em);
		usuarioDAO.insert(usuario1);
		usuarioDAO.insert(usuario2);
		usuarioDAO.insert(usuario3);
		//FIM  3 USURIOS DEFAULT





		//INICIO da persistencia de 3 ASSISTENTE	
		List<Avaliacao> listAvaiacao1 = new ArrayList<>();
		listAvaiacao1.add(avaliacao1);

		List<Avaliacao> listAvaiacao2 = new ArrayList<>();
		listAvaiacao2.add(avaliacao2);

		List<Avaliacao> listAvaiacao3 = new ArrayList<>();
		listAvaiacao3.add(avaliacao3);




		//FIM da persistencia de 3 ASSISTENTE

		//INICIO da persistencia de 3 Identificacao	
		List<String> listPecas1 = new ArrayList<>();
		listPecas1.add("ListaDePecas1?");

		List<String> listPecas2 = new ArrayList<>();
		listPecas2.add("ListaDePecas2?");

		List<String> listPecas3 = new ArrayList<>();
		listPecas3.add("ListaDePecas3?");

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
		Especialidade especialidade6 = new Especialidade("6Especialidade");
		
		especialidadeDAO.insert(especialidade4);
		especialidadeDAO.insert(especialidade5);
		especialidadeDAO.insert(especialidade6);
				



		
		
		
		
		
		usuario2.setTipoUsuario(TipoUsuario.ASSISTENTE);
		usuario2.setDiaLogado(true);
		usuario2.setIdentificacao(identificacao2);
		usuario2.setListaAvaliacoes(listAvaiacao2);
		usuario2.getEspecialidade().add(especialidade1);
		usuario2.getEspecialidade().add(especialidade2);
		usuario2.getEspecialidade().add(especialidade3);
		usuarioDAO.update(usuario2);

		usuario3.setTipoUsuario(TipoUsuario.ASSISTENTE);
		usuario3.setDiaLogado(true);
		usuario3.setIdentificacao(identificacao3);
		usuario3.setListaAvaliacoes(listAvaiacao3);
		usuario3.getEspecialidade().add(especialidade4);
		usuario3.getEspecialidade().add(especialidade5);
		usuario3.getEspecialidade().add(especialidade6);
		usuarioDAO.update(usuario3);

		////////////busca
		
		List<Usuario> listaUsuarioPorAssistente =  usuarioDAO.BuscarAssistentePorEspecialidade(4);
		for (Usuario usuario : listaUsuarioPorAssistente) {
			System.out.println(usuario.getNome()); 
		}



	}

}
