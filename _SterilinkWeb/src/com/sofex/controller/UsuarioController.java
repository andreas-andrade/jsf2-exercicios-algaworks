package com.sofex.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sofex.controle.IControlePesquisa;

@ManagedBean
@RequestScoped
public class UsuarioController {
	
	private String login;
	private String password;
	
	public String verificaLogin() {		
						
		String pagina = null;
		
		ApplicationContext context = null;
		context = new FileSystemXmlApplicationContext("sterilink-client.xml");
		IControlePesquisa pesquisa = (IControlePesquisa) context.getBean("pesquisaService");
				
		
		// TODO: corrigir o c�digo abaixo:
		/*Requerente req = new Requerente();
		req.setNomusu(login);
		List<?> lista = (List<?>) pesquisa.listarPorEntidade(Requerente.class, req);
		boolean achou = false;

		if (lista.size() > 0)
		{
			Iterator<?> it = lista.iterator();
			while (it.hasNext() && !achou)
			{
				req = (Requerente) it.next();
				if (req.getSenusu().compareToIgnoreCase(req.criptografaComMD5(password)) == 0)
					achou = true;
			}
			if (achou)
				pagina = "logou.xhtml";
			else
				pagina = "falha.xhtml";
		}*/
		
		
		if (login != null || password != null) {
			pagina = login.equals("teste") && password.equals("teste") ? "logou.xhtml" : "falha.xhtml";
		} else {
			pagina = "index.xhtml";
		}
		
		return pagina; 		
	}
	
	//==============================================================
	// Getters e Setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//==============================================================
}
