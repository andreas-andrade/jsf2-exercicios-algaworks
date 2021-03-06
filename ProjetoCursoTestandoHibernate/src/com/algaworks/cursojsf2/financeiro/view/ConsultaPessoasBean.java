package com.algaworks.cursojsf2.financeiro.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConsultaPessoasBean {
	private List<String> pessoas = new ArrayList<String>();
	
	@PostConstruct
	public void inicializar() {
		for (int i = 0; i < 20; i++) {
			pessoas.add("");
		}
	}

	public List<String> getPessoas() {
		return pessoas;
	}
}
