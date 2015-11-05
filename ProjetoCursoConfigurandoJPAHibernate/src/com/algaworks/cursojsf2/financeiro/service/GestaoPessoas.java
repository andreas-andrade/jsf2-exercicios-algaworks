package com.algaworks.cursojsf2.financeiro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoPessoa;

public class GestaoPessoas
{

	private static Map<Integer, Pessoa> pessoas = new HashMap<Integer, Pessoa>();
	
	static {
		pessoas.put(1, new Pessoa(1, "Jose Pereira Souza", TipoPessoa.FISICA));
		pessoas.put(2, new Pessoa(2, "Milenio Despachane", TipoPessoa.JURIDICA));
		pessoas.put(3, new Pessoa(3, "Padaria São Gabriel", TipoPessoa.JURIDICA));
		pessoas.put(4, new Pessoa(4, "Auto-peças do Edson", TipoPessoa.JURIDICA));
		pessoas.put(5, new Pessoa(5, "Cemig", TipoPessoa.JURIDICA));
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