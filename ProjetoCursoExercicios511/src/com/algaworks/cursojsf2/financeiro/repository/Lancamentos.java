package com.algaworks.cursojsf2.financeiro.repository;

import java.util.List;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;

public interface Lancamentos {
	List<Lancamento> todos();

	Lancamento guardar(Lancamento lancamento);

	void remover(Lancamento lancamento);

	Lancamento comDadosIguais(Lancamento lancamento);
	
	List<Lancamento> pesquisarLancamentosDePessoas(Pessoa pessoa);
	
	public boolean existemPara(Pessoa pessoa);
}
