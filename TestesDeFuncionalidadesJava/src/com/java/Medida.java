package com.java;

public enum Medida {
	MM("Milímetro"), CM("Centímetro"), M("Metro");
	
	public String titulo;
	
	Medida(String titulo) {
		this.titulo = titulo;
	}
}
