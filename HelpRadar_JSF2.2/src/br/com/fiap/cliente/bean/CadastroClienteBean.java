package br.com.fiap.cliente.bean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fiap.cliente.dao.ClienteDAO;
import br.com.fiap.cliente.dao.impl.ClienteDAOImpl;
import br.com.fiap.cliente.entity.Cliente;
import br.com.fiap.dao.EntityManagerFactorySingleton;

@ManagedBean
@SessionScoped
public class CadastroClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
	private ClienteDAO clienteDAO;
	
	@PostConstruct
	public void init(){
		cliente = new Cliente();
		clienteDAO = new ClienteDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	//Método responsável por gravar o arquivo em disco
	public void sobeFoto(FileUploadEvent event){
		/* Código para subir a imagem em um diretório do servidor
		//Recupera o nome do arquivo enviado
		String nomeArquivo = event.getFile().getFileName();

		//Cria o arquivo no diretório escolhido
		File file = new File("C:\\Fotos\\"+nomeArquivo);
		try {
			FileOutputStream output = new FileOutputStream(file);
			//Escreve o conteúdo do arquivo
			output.write(IOUtils.toByteArray(event.getFile().getInputstream()));
			output.close();			
			//Armazena o nome do arquivo de imagem no cliente
			cliente.setFoto(nomeArquivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		try {
			cliente.setFoto(IOUtils.toByteArray(event.getFile().getInputstream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StreamedContent getFoto(){
		FacesContext context = FacesContext.getCurrentInstance();
		//A foto que será exibida na página
		DefaultStreamedContent foto = new DefaultStreamedContent();
		foto.setContentType("image/jpg");
		
		try {
			if (cliente.getFoto() == null || context.getRenderResponse()){
				foto.setStream(new FileInputStream("C:\\Fotos\\semImagem.jpg"));
			}else{
				//Coloca a foto armazenado no diretório do servidor
				//foto.setStream(new FileInputStream("C:\\Fotos\\"+cliente.getFoto()));
				//Coloca a foto armazenado no banco de dados
				foto.setStream(new ByteArrayInputStream(cliente.getFoto()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return foto;
		
	}
	
	//Coloca um novo cliente no formulário
	public void novo(){
		cliente = new Cliente();
	}
	
	//Trata o menu Cadastrar do template
	public String novoCliente(){
		//Cria um novo cliente
		cliente = new Cliente();
		//Redireciona para a página de cadastro
		return "/xhtml/cliente/cadastro?faces-redirect=true";
	}

	public void cadastrar(){
		String msg = "";
		//Verifica se o cliente é novo
		if (cliente.getId() == 0){
			clienteDAO.insert(cliente);
			msg = "Cliente Cadastrado com Sucesso!";
		}else{
			clienteDAO.update(cliente);
			msg = "Cliente Atualizado com Sucesso!";
		}
		//Exibe uma mensagem de sucesso
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(msg));
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
