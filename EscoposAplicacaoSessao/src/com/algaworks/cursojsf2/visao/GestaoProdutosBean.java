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

import com.algaworks.cursojsf2.dominio.Produtos;

@ManagedBean
//@NoneScoped
//@RequestScoped
//@ViewScoped
//@SessionScoped
//@ApplicationScoped
public class GestaoProdutosBean implements Serializable {
	private Produtos produto; 
	private List<Produtos> listaDeProdutos;
	
	public GestaoProdutosBean(){
		this.listaDeProdutos = new ArrayList<Produtos>();
		this.produto = new Produtos();
	}
	
	public List<Produtos> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void incluir(){
		this.listaDeProdutos.add(this.produto);
		this.produto = new Produtos();
	}
	
	public Produtos getProduto() {
		return produto;
	}
	
	//saber quando o bean é inicializado
	@PostConstruct
	public void inicializar(){
		System.out.println("Inicializou bean!");
	}
	
	//para saber quando o bean é finalizado
	@PreDestroy
	public void finalizar(){
		System.out.println("Finalizando bean!");
	}
}
