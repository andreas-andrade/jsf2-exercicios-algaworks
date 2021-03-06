package com.algaworks.cursojsf2;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;


@ManagedBean
@RequestScoped
public class UploadBean {
	private String descricao;
	private Part arquivo; 
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}

	private void adicionarMensagem(Severity nivel,String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nivel, msg, msg));
	}
	
	public void enviar(){
		String nomeArquivoSaida = "D:/Arquivos Uploadados/" + arquivo.getSubmittedFileName();
		try (InputStream is = arquivo.getInputStream();
				OutputStream out = new FileOutputStream(nomeArquivoSaida)){
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = is.read(bytes)) != -1){
				out.write(bytes, 0, read);
			}
			
			adicionarMensagem(FacesMessage.SEVERITY_INFO, "Arquivo \"" + descricao + "\" enviado com sucesso.");
		} catch (Exception e) {
			adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao enviar arquivo");
		}
	}
}
