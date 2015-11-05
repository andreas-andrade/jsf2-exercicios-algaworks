package com.algaworks.cursojsf2.financeiro.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.algaworks.cursojsf2.financeiro.util.FacesUtil;


/**
 * @author Andreas
 *
 */
@ManagedBean
public class SegurancaBean {
	public String usuario;
	public String senha;
	
	//------ Getters e setters----------------
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String logar(){
		// pegamos o request
		HttpServletRequest request = this.getRequest();
		try {
			request.login(this.usuario, this.senha);
			return "Home?faces-redirect=true";
		} catch (ServletException e) {
			String erro = FacesUtil.getMensagemI18N("username_password_does_not_match");
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, erro);
			return null;
		}
	}
	
	public String sair() throws ServletException{
		HttpServletRequest request = getRequest();
		request.logout();
		return "Home?faces-redirect=true";
		//return "Login?faces-redirect=true";
	}
	
	private HttpServletRequest getRequest(){
		// pegamos o contexto
		FacesContext context = FacesContext.getCurrentInstance();
		// pegamos o request
		return (HttpServletRequest) context.getExternalContext().getRequest();
	}
}
