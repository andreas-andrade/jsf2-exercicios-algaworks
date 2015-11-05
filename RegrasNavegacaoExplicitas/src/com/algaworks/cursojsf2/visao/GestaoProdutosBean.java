package com.algaworks.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.algaworks.cursojsf2.dominio.Produto;

@ManagedBean
@ApplicationScoped
public class GestaoProdutosBean implements Serializable {

	private List<Produto> produtos;
	private Produto produto;

	public GestaoProdutosBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public String obterAjuda() {
		if (this.produtos.isEmpty()) {
			return "sem-produtos";
		} else {
			return "com-produtos";
		}
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
}