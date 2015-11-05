package com.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class DataAtual {
	public static void main(String[] args) {
		Date dataAtual = new Date();
		DateFormat formater = new SimpleDateFormat("dd/MM/yyyy ");
		System.out.println("Data atual: " + formater.format(dataAtual));
		System.out.println("Data atual: " + dataAtual);
		
		for(String id : TimeZone.getAvailableIDs()) {
		    System.out.println(id);
		}
		
		
	}
}
