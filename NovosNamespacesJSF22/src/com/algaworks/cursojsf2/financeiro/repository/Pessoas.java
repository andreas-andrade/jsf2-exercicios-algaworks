package com.algaworks.cursojsf2.financeiro.repository;

import java.util.List;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;

public interface Pessoas {

	/**
	 * Método que lista todas as pessoas do banco de dados.
	 * @return List de Pessoa
	 */
	 List<Pessoa> todas();
	 
	 /**
	  * Método que retorna um registro de Pessoa do banco de dados.
	  * @param codigo
	  * @return Pessoa
	  */
	 Pessoa porCodigo(Integer codigo);
	 
	 Pessoa guardar(Pessoa pessoa);
	 
	 void remover(Pessoa pessoa);
	 
}
