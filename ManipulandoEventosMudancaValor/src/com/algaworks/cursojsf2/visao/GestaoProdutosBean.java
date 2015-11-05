package com.algaworks.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.dominio.Produtos;

//@NoneScoped
//@RequestScoped
//@ViewScoped
//@ApplicationScoped
@ManagedBean
@SessionScoped
public class GestaoProdutosBean implements Serializable {
	private Produtos produto; 
	private Produtos produtoSelecionado;
	private List<Produtos> listaDeProdutos;
	private String fabricantePesquisa;
	
	public String getFabricantePesquisa() {
		return fabricantePesquisa;
	}

	public void setFabricantePesquisa(String fabricantePesquisa) {
		this.fabricantePesquisa = fabricantePesquisa;
	}

	public Produtos getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produtos produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public GestaoProdutosBean(){
		this.listaDeProdutos = new ArrayList<Produtos>();
		this.produto = new Produtos();
	}
	
	public List<Produtos> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void incluir(){
		System.out.println("Incluindo...");
		this.listaDeProdutos.add(this.produto);
		this.produto = new Produtos();
	}
	
	public Produtos getProduto() {
		return produto;
	}
	
	//saber quando o bean � inicializado
	@PostConstruct
	public void inicializar(){
		System.out.println("Inicializou bean!");
	}
	
	//para saber quando o bean � finalizado
	@PreDestroy
	public void finalizar(){
		System.out.println("Finalizando bean!");
	}
	
	public String obterAjuda() {
		if (listaDeProdutos.isEmpty()) {
			return "ajuda?faces-redirect=true";
		} else {
			return "ajuda-telefone?faces-redirect=true";
		}
	}
	
	/*
	 * o parametro ActionEvent é necessário para lidar com eventos de elementos no xhtml
	 */
	public void verificarInclusao(ActionEvent event){
		System.out.println("Verificando...");
		/*
		 * "".equals é para evitar que o getFabricante não gere um null exception, caso ele não exista... é gambiarra
		 */
		if ("".equals(this.produto.getFabricante())) {
			this.produto.setFabricante("Sem Fabricante");
		}
	}

	public void excluir() {
		this.listaDeProdutos.remove(this.produtoSelecionado);
	}

	public void pesquisar() {
		System.out.println("Pesquisando...");
	}

	public void fabricantePesquisaAlterado(ValueChangeEvent event) {
		
		/*
		 * Ilustrando como se obtem os valores no campo de input text
		 */
		System.out.println("Evento de mudança de valor capturado...");
		System.out.println("Valor atual: " + this.fabricantePesquisa);
		System.out.println("Novo Valor: " + event.getNewValue());
	}
		

}
