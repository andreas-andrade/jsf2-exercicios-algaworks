package com.algaworks.cursojsf2.financeiro.repository;

import java.util.List;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;

public interface Lancamentos {
	 List<Lancamento> todos();
	 Lancamento guardar(Lancamento lancamento);
	 void remover(Lancamento lancamento);
}
