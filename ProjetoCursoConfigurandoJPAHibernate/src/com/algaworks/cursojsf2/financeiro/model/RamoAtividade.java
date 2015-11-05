package com.algaworks.cursojsf2.financeiro.model;

import java.io.Serializable;

public class RamoAtividade implements Serializable {
	
	private Integer codigo;
	private String descricao;
	
	public RamoAtividade() {};
	
	public RamoAtividade(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
