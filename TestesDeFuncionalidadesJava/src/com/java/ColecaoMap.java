package com.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ColecaoMap {

	public static void main(String[] args) {
		Map<String, String> paises = new HashMap<>();
		paises.put("BR", "Brasil");
		paises.put("RU", "Rússia");
		paises.put("IN", "Índia");
		paises.put("CN", "China");
		System.out.println(paises);
		System.out.println("-------------------");
		System.out.println(paises.containsKey("BR"));
		System.out.println(paises.containsKey("US"));
		System.out.println(paises.containsValue("Brasil"));
		System.out.println(paises.get("BR"));
		paises.remove("RU");
		System.out.println(paises);
		
		System.out.println(paises.keySet());
		Set<String> keys = paises.keySet();
		for (String key : keys) {
			System.out.println(key + ": " + paises.get(key));
		}
	}

}
