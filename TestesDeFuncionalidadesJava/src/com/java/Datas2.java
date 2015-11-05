package com.java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Datas2 {

	public static void main(String[] args) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.set(1980, Calendar.MONTH, 12);
		Date date = cal.getTime();
		
		// Formatação de datas
		DateFormat f = DateFormat.getDateInstance();
		String dataTexto= f.format(date);
		System.out.println("Data: " + dataTexto);
		System.out.println("----------------------------");

		// Formatação de Hora
		f = DateFormat.getTimeInstance();
		dataTexto= f.format(date);
		System.out.println("Hora: " + dataTexto);

		// Formatação de Hora e Data
		f = DateFormat.getDateTimeInstance();
		dataTexto= f.format(date);
		System.out.println("Data e hora: " + dataTexto);
		
		System.out.println("----------------------------");
		
		
		// Estilos
		// Formatação de datas
		f = DateFormat.getDateInstance(DateFormat.FULL);
		dataTexto= f.format(date);
		System.out.println("Data: " + dataTexto);
		
		f = DateFormat.getDateInstance(DateFormat.LONG);
		dataTexto= f.format(date);
		System.out.println("Data: " + dataTexto);
		
		f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		dataTexto= f.format(date);
		System.out.println("Data: " + dataTexto);
		
		f = DateFormat.getDateInstance(DateFormat.SHORT);
		dataTexto= f.format(date);
		System.out.println("Data: " + dataTexto);
		
		Date dataConvertida = f.parse("15/08/1914");
		System.out.println("Data convertida de string: " + dataConvertida);
		
		
		System.out.println("----------------------------");
		/*SimpleDateFormat*/
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf.parse("12/12/2012 "));
		System.out.println(sdf.format(date));
	}

}
