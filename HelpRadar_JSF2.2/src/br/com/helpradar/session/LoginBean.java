package br.com.helpradar.session;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable{

	
	
	public void deslogar(){
		//Recuperar a sessão do usuário
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession)
				context.getExternalContext().getSession(false);
		//Invalidar a sessão
		session.invalidate();
		//Ir para a página de login
		
	}
	
	public void logar(String userId, String displayName){
			HttpSession session = request.getSession();
			//Adiciona informação na sessão -> (chave, valor)
			session.setAttribute("userId", userId);
			session.setAttribute("displayName", displayName);
		
	}




	
}



