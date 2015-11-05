package com.algaworks.cursojsf2.financeiro.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {
	public static void adicionarMensagem(Severity tipo, String msg) {
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, msg, msg));
	}
	
	public static String getMensagemI18N(String chave){
		FacesContext context = FacesContext.getCurrentInstance();
		String msg = context.getApplication().getResourceBundle(context, "msg").getString(chave);
		return msg;
	}
	
	/**
	 * Este método devolve um objeto do tipo HttpServletRequest, que é o external request. 
	 * Esse request está sendo monitorado por um javax.filter, para que seja possível saber quando o usuário começa 
	 * a fazer suas requisições e possibilite controlar quando as sessões e transações devem ser abertas e fechadas.
	 * @author Andreas Andrade Adelino
	 * @param name String - o nome do objeto a ser buscado
	 */
	public static Object getRequestAttribute(String name){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		return request.getAttribute(name);
	}
}
