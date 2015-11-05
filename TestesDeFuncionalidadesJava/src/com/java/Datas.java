package com.java;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Datas{
		public static void main(String args[]){

		Instant inicio = Instant.now();

		LocalDate hoje = LocalDate.now();
		System.out.println("Data utilizando localdate: " + hoje.toString());	
		System.out.println("Data em mili: "+System.currentTimeMillis());
		Date data = new Date();
		System.out.println("Data utilizando a classe Date: " + data);
		
		Date dataTeste = new Date(1413980779193L);
		System.out.println("Data utilizando a classe Date: " + dataTeste);
		/* Métodos da Classe Date */
		//data.getTime(); 
		//data.setTime(100101000);
		System.out.println("Comparação das datas " + data + " e " + dataTeste + " = " + data.compareTo(dataTeste));
		/*
		 * data.compareTo(dataTeste);
		 * compareTo retorna -1, 0 ou 1, respectivamente se o primeiro valor é menor que o segundo, se são iguais ou se o primeiro é maior
		 */
		
		// Trabalhando com a classe abstrata Calendar
		
		// O método getInstance retorna um calendario gregoriano.
		Calendar cal = Calendar.getInstance();
		cal.set(1950, Calendar.FEBRUARY, 12, 14, 20);
		System.out.println("Data utilizando a classe Calendar: " + cal.getTime());
		System.out.println("Obtendo o ano do objeto calendário: " + cal.get(Calendar.YEAR));
		System.out.println("Obtendo o mes do objeto calendário: " + cal.get(Calendar.MONTH));
		System.out.println("Obtendo o dia do objeto calendário: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Obtendo o hora do dia do objeto calendário: " + cal.get(Calendar.HOUR_OF_DAY));
		
		cal.set(Calendar.YEAR, 2011);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		cal.set(Calendar.HOUR_OF_DAY, 15);
		System.out.println("Data utilizando a classe Calendar: " + cal.getTime());
		System.out.println("Obtendo a HOUR: " + cal.get(Calendar.HOUR));

		// o método add altera o dia, mas se acabar ele vira para o mes seguinte e assim por diante
		cal.add(Calendar.DAY_OF_MONTH, 5);
		System.out.println("Data utilizando a classe Calendar: " + cal.getTime());
		
		// o método roll só altera o campo do método e se estourar, ele começa a contar do início
		cal.roll(Calendar.DAY_OF_MONTH, 25);
		System.out.println("Data utilizando a classe Calendar: " + cal.getTime());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		
		Calendar c = Calendar.getInstance();
		int hora = c.get(Calendar.HOUR_OF_DAY);
		if (hora <= 12) {
			System.out.println("Bom Dia!");
		} else if (hora > 12 && hora < 18) {
			System.out.println("Boa tarde!");
		} else {
			System.out.println("Boa noite!");
		}
		// ---------------------------------------------------------------------------------------------------------
		Instant fim = Instant.now();
		Duration duracao = Duration.between(inicio, fim);
		long duracaoMili = duracao.toMillis();
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		System.out.println("A duração de execução do programa foi de: " + duracaoMili);
	}
}