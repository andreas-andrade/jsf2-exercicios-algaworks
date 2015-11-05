package com.algaworks.cursojsf2.financeiro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;

public class GestaoPessoas
{

	private static Map<Integer, Pessoa> pessoas = new HashMap<Integer, Pessoa>();
	
	static {
		pessoas.put(1, new Pessoa(1, "Jose Pereira Souza"));
		pessoas.put(2, new Pessoa(2, "Milenio Despachane"));
		pessoas.put(3, new Pessoa(3, "Padaria São Gabriel"));
		pessoas.put(4, new Pessoa(4, "Auto-peças do Edson"));
		pessoas.put(5, new Pessoa(5, "Cemig"));
	}
	
	public List<Pessoa> listarTodas() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(GestaoPessoas.pessoas.values());
		return pessoas;
	}
	
	public Pessoa buscarPorCodigo(Integer codigo) {
		return pessoas.get(codigo);
	}
	
}