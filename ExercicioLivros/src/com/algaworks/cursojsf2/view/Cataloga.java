package com.algaworks.cursojsf2.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.dominio.Livros;

@ManagedBean
//@ApplicationScoped
@ApplicationScoped
public class Cataloga {
	private Livros livros;
	private Livros livroSelecionado;
	private String livroPesquisa;
	private List<Livros> listaDeLivros;
	private List<Livros> listaDeLivrosPesquisados;
	
	private String livro;
	private String[] listaDeLivrosSelecionados;
	// ---------------------------------------------------------------------------------



	public String[] getListaDeLivrosSelecionados() {
		return listaDeLivrosSelecionados;
	}

	public void setListaDeLivrosSelecionados(String[] listaDeLivrosSelecionados) {
		this.listaDeLivrosSelecionados = listaDeLivrosSelecionados;
	}

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	private HtmlOutputText msgSucesso;
	
	public Cataloga() {
		this.livros = new Livros();
		this.listaDeLivros = new ArrayList<Livros>();
		this.listaDeLivrosPesquisados = new ArrayList<Livros>();
	}
	
	public String getLivroPesquisa() {
		return livroPesquisa;
	}

	public void setLivroPesquisa(String livroPesquisa) {
		this.livroPesquisa = livroPesquisa;
	}

	public Livros getLivroSelecionado() {
		return livroSelecionado;
	}

	public void setLivroSelecionado(Livros livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}

	
	public void setMsgSucesso(HtmlOutputText msgSucesso) {
		this.msgSucesso = msgSucesso;
	}

	public HtmlOutputText getMsgSucesso() {
		return msgSucesso;
	}

	
	public void incluirLivro(){
		if (this.getLivros().getTitulo() == "") {
			adicionarMensagem("form:titulo", FacesMessage.SEVERITY_ERROR, "Título não informado.", "Por favor, informe o título do livro.");
			adicionarMensagem(null, FacesMessage.SEVERITY_ERROR, "Preencha os campos necessários!", "Preencha os campos necessários!" );
		}
		if (this.getLivros().getAutores() == "") {
			adicionarMensagem("form:autores", FacesMessage.SEVERITY_ERROR, "Autor(es) não informado(s).", "Por favor, informe o(s) autor(es) do livro.");
		}
		if (this.getLivros().getAssunto() == "") {
			adicionarMensagem("form:assunto", FacesMessage.SEVERITY_WARN, "Assunto não informado.", "Assunto do livro não informado.");
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
		if (! context.getMessages().hasNext()) {
			this.listaDeLivros.add(this.livros);
			// instancia
			this.livros = new Livros();
			this.msgSucesso.setValue("Livro cadastrado com sucesso!");
			this.msgSucesso.setStyle("font-weight: bold; font-size: 18px; color: green; border: 2px solid green");
		}
	}

	public Livros getLivros() {
		return livros;
	}

	public List<Livros> getListaDeLivros() {
		return listaDeLivros;
	}
	
	//saber quando o bean � inicializado
	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou bean!");
	}

	// para saber quando o bean � finalizado
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizando bean!");
	}
	
	public void excluir(){
		this.listaDeLivros.remove(this.livroSelecionado);
		this.msgSucesso.setValue("");
		this.msgSucesso.setStyle("");
	}
	
	public List<Livros> getListaDeLivrosPesquisados() {
		return listaDeLivrosPesquisados;
	}
	
	public void buscarLivros(ValueChangeEvent event){
		System.out.println("evento de mudança de valor capturado...");
		System.out.println("Valor no bean: " + this.livroPesquisa);
		System.out.println("Valor atual: " + event.getNewValue().toString());
		
		this.listaDeLivrosPesquisados.clear();
		try{
			for (Livros livro : this.listaDeLivros) {
				if (livro.getTitulo() != null && livro.getTitulo().toLowerCase().startsWith(event.getNewValue().toString().toLowerCase())) {
					listaDeLivrosPesquisados.add(livro);
					//System.out.println("livro adicionado: " + livro);
				}
			}
		} catch (Exception e) {
			System.out.println("Deu erro aqui: " + e.getMessage());
		}
		this.msgSucesso.setValue("");
		this.msgSucesso.setStyle("");
	}

	public String obterAjuda() {
		if (listaDeLivros.isEmpty()) {
			return "ajuda";
		} else {
			return "ajuda-telefone";
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
	
	public void escolher() {
		System.out.println("---------------------");
		for (String livro : this.getListaDeLivrosSelecionados()) {
			System.out.println(livro);
		}
	}
}
