package com.algaworks.cursojsf2.financeiro.service;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;

public class GestaoLancamentos {
	private Lancamentos lancamentos;

	public GestaoLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	public void excluir(Lancamento lancamento) throws RegraNegocioException {
		if (lancamento.isPago()) {
			throw new RegraNegocioException("Lançamentos pagos não podem ser excluídos");
		}
		this.lancamentos.remover(lancamento);
	}
	
	public void salvar(Lancamento lancamento) throws RegraNegocioException {
		if(existeLancamentoSemelhante(lancamento)) {
			throw new RegraNegocioException("Já existe um lancamento igual a este.");
		}
		this.lancamentos.guardar(lancamento);
	}
	
	public Boolean existeLancamentoSemelhante(Lancamento lancamento) {
		Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);
		return lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento);
	}
}

