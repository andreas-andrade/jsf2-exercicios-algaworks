package com.algaworks.cursojsf2.financeiro.model;

public enum TipoPessoa {
	FISICA("Física"), JURIDICA("Jurídica");
	
	public String getTipo() {
		return tipo;
	}

	private String tipo;

	private TipoPessoa(String tipo) {
		this.tipo = tipo;
	}
	
}
