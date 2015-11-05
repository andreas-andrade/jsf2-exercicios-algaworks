package com.algaworks.cursojsf2.financeiro.service;

import java.util.List;

import com.algaworks.cursojsf2.financeiro.model.RamoAtividade;
import com.algaworks.cursojsf2.financeiro.repository.RamosDeAtividade;

public class GestaoRamosDeAtividade {
	private RamosDeAtividade ramosDeAtividade;
	
	public GestaoRamosDeAtividade(RamosDeAtividade ramosDeAtividade) {
		this.ramosDeAtividade = ramosDeAtividade;
	}
	
	public List<RamoAtividade> listar() {
		return this.ramosDeAtividade.todos();
	}
	
}
