package com.algaworks.cursojsf2;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class CadastroUsuarioBean {

	private String nome;
	private String email;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void cadastrar() {
		if (this.getNome() == null || this.getNome().length() < 10) {
			this.adicionarMensagem("frm:nome", FacesMessage.SEVERITY_ERROR, "Nome incompleto.", "Favor informar seu nome completo.");
		}
		if (this.getEmail() == null || this.getEmail().length() < 10) {
			this.adicionarMensagem("frm:email", FacesMessage.SEVERITY_ERROR, "E-mail incompleto!", "Favor informar seu e-mail completo!");
		}
		if (hojeEDiaDeDescanso()) {
			this.adicionarMensagem(null, FacesMessage.SEVERITY_WARN, "Hoje é dia de descanso", "Você não pode cadastrar usuários hoje!");
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
		if (!context.getMessages().hasNext()) {
			/*
			 * Aqui eu posso cadastrar o usuário no BD e fazer o que eu mais desejar
			 */
			
			this.adicionarMensagem("", FacesMessage.SEVERITY_INFO, "Usuário Cadastrado", "Usuário cadastrado com sucesso!");
		}
		
	}
	
	private void adicionarMensagem(String clienteId, Severity severity, String summary, String detail) {
		/*
		 * FacesContext é um objeto que contém informações sobre a atual requisição do usuário
		 */
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage(severity, summary, detail);
		context.addMessage(clienteId, mensagem);
		
	}
	
	private boolean hojeEDiaDeDescanso() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
	}
	
}