package com.algaworks.cursojsf2.financeiro.model;

import java.io.Serializable;
import java.util.Date;

public class Pessoa implements Serializable {

	private Integer codigo;
	private String nome;
	private TipoPessoa tipo;
	private RamoAtividade ramoDeAtividade;
	private String email;
	private Date dataDeNascimento;

	public Pessoa() {}
	
	public Pessoa(Integer codigo, String nome, TipoPessoa tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public RamoAtividade getRamoDeAtividade() {
		return ramoDeAtividade;
	}

	public void setRamoDeAtividade(RamoAtividade ramoDeAtividade) {
		this.ramoDeAtividade = ramoDeAtividade;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}