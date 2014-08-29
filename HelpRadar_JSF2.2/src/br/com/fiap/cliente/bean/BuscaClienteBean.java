package br.com.fiap.cliente.bean;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fiap.cliente.dao.ClienteDAO;
import br.com.fiap.cliente.dao.impl.ClienteDAOImpl;
import br.com.fiap.cliente.entity.Cliente;
import br.com.fiap.dao.EntityManagerFactorySingleton;

@ManagedBean
@SessionScoped
public class BuscaClienteBean implements Serializable {

	private List<Cliente> lista;

	private ClienteDAO dao;

	// Armazena o nome da busca inserido pelo usuário
	private String nomeBusca;

	// Armazena o id do cliente a ser removido
	// O botão de excluir da tabela que preenche esse valor
	private int idClienteRemover;
	
	private byte[] fotoCliente;

	// Método de inicialização do MB
	@PostConstruct
	private void init() {
		// Criar o EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		// Instanciar o dao
		dao = new ClienteDAOImpl(em);
		// Preencher a lista de clientes
		lista = dao.buscarTodos();
	}

	public StreamedContent getFoto() {
		DefaultStreamedContent content = new DefaultStreamedContent();
		
		try {
			if (fotoCliente == null) {
				content.setStream(new FileInputStream(
						"C:\\Fotos\\semImagem.jpg"));
			} else {
				content.setStream(new ByteArrayInputStream(fotoCliente));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return content;
	}

	// Trata o clique do botão SIM do dialog de confirmação
	public void remove() {
		// Remove o cliente do banco de dados
		dao.removeById(idClienteRemover);
		// Adiciona a mensagem de sucesso
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Cliente Removido!"));
		// Atualiza a lista
		lista = dao.buscarTodos();
	}

	// Trata o clique do botão Buscar
	public void buscarPorNome() {
		// Atualiza a lista da tabela com a busca por nome
		lista = dao.buscarPorNome(nomeBusca);
	}

	// Retorna os nomes dos clientes para o autocomplete
	public List<String> completarNome(String nome) {
		return dao.buscarNome(nome);
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

	public int getIdClienteRemover() {
		return idClienteRemover;
	}

	public void setIdClienteRemover(int idClienteRemover) {
		this.idClienteRemover = idClienteRemover;
	}

	public String getNomeBusca() {
		return nomeBusca;
	}

	public void setNomeBusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}

	public byte[] getFotoCliente() {
		return fotoCliente;
	}

	public void setFotoCliente(byte[] fotoCliente) {
		this.fotoCliente = fotoCliente;
	}

}
