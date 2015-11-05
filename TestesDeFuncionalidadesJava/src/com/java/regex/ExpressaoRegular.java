package com.java.regex;

public class ExpressaoRegular {

	public static void main(String[] args) {
		
		boolean b = "Java".matches("java");
		System.out.println(b);
		
		/*
		 * MODIFICADORES
		 * (?i), Ignora maiúscula e minúscula
		 * (?x), Comentários
		 * (?m), Multilinhas
		 * (?s), Dottal
		 */
		b = "Java".matches("(?imxs)java");
		System.out.println(b);
		
		/*
		 * METACARACTERES
		 * .   qualquer caracter
		 * \d  dígitos 		[0-9]
		 * \D  não dígitos  [^0-9]
		 * \s  espaços 		[\t\n\x0B\f\r]
		 * \S  não é espaço [^\s]
		 * \w  letra 		[a-zA-Z_0-9]
		 * \W  não letra
		 */
	}

}
