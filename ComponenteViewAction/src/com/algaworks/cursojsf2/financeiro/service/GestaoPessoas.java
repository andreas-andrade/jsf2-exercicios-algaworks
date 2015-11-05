package com.algaworks.cursojsf2.financeiro.service;

import java.util.List;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;

public class GestaoPessoas {
	private Pessoas pessoas;
	private Lancamentos lancamentos;
	
	public GestaoPessoas(Pessoas pessoas, Lancamentos lancamentos) {
		this.pessoas = pessoas;
		this.lancamentos = lancamentos;
	}
	
	public void salvar(Pessoa pessoa) {
		pessoas.guardar(pessoa);
	}
	
	public void excluir(Pessoa pessoa) throws RegraNegocioException {
		if (this.lancamentos.existemPara(pessoa)) {
			throw new RegraNegocioException("Esta pessoa não pode ser excluída porque existem lançamentos pendentes!");
		}
		this.pessoas.remover(pessoa);
	}
	
	public List<Pessoa> listar() {
		return this.pessoas.todas();
	}
}
