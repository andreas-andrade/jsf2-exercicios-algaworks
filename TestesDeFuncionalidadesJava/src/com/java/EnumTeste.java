package com.java;

public class EnumTeste {

	public static final double PI = 3.14;
	
	public static void andar(Medida medida, int total) {
		System.out.println("Andou " + total + " " + medida.titulo + "(s)");
	}
	
	public static void main(String[] args) {
		System.out.println("Funciona.");
		System.out.println(PecasXadrez.BISPO);
		System.out.println("----------------------------");
		System.out.println(Medida.M.titulo);
		
		for (Medida m : Medida.values()) {
			System.out.println("medida: " + m + " - " + m.titulo);
		}
		
		andar(Medida.MM, 150);
		andar(Medida.M, 150);
		andar(Medida.CM, 150);
	}

}
