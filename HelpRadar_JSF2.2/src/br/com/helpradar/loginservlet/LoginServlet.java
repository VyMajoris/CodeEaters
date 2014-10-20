package br.com.helpradar.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.helpradar.session.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
@ManagedBean
@RequestScoped
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		LoginBean loginBean = new LoginBean();

		String userId = request.getParameter("userId");
		String displayName = request.getParameter("displayName");
		String valid = "no";

		//se essa string tiver valor, é porque o usuário quer deslogar
		String logout = request.getParameter("logout");

		System.out.println(request.getParameter("userId"));
		System.out.println(request.getParameter("displayName"));

		//logar
		if (userId != null) {
			//loginBean.logar(userId, displayName);
			HttpSession session = request.getSession(true);
			//Adiciona informação na sessão -> (chave, valor)
			session.setAttribute("userId", userId);
			session.setAttribute("displayName", displayName);
			valid = "yes";
			
			
		}

		//deslogar
		if (logout != null) {
			HttpSession session = request.getSession(false);
			//Adiciona informação na sessão -> (chave, valor)
			System.out.println("Logging out: "+session.getAttribute("userId"));
			session.invalidate();
		}

		
		//return result para o usuário
		PrintWriter writer =  response.getWriter();
		try{
			
			
			writer.write(valid);
			writer.close();
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	//Session volta como null pelo FacesContext context = FacesContext.getCurrentInstance(); 
	private String deslogar() {
		//Recuperar a sessão do usuário
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession)
				context.getExternalContext().getSession(false);
		//Invalidar a sessão
		session.invalidate();

		return  "/xhtml/landing/landing.xhtml";
	}

	private void logar(String userId, String displayName) {
		FacesContext context = FacesContext.getCurrentInstance();
		//Recupera a sessão do usuário... true -> cria uma sessão se não existe
		HttpSession session = (HttpSession)
				context.getExternalContext().getSession(true);
		//Adiciona informação na sessão -> (chave, valor)
		session.setAttribute("userId", userId);
		session.setAttribute("displayName", displayName);
	}

}
