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
		//Recuperar a sess�o do usu�rio
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession)
				context.getExternalContext().getSession(false);
		//Invalidar a sess�o
		session.invalidate();
		//Ir para a p�gina de login
		
	}
	
	public void logar(String userId, String displayName){
			HttpSession session = request.getSession();
			//Adiciona informa��o na sess�o -> (chave, valor)
			session.setAttribute("userId", userId);
			session.setAttribute("displayName", displayName);
		
	}




	
}



