package com.algaworks.cursojsf2.financeiro.util;

import java.io.Serializable;

import org.hibernate.Session;

import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;
import com.algaworks.cursojsf2.financeiro.repository.RamosDeAtividade;
import com.algaworks.cursojsf2.financeiro.repository.infra.LancamentosHibernate;
import com.algaworks.cursojsf2.financeiro.repository.infra.PessoasHibernate;
import com.algaworks.cursojsf2.financeiro.repository.infra.RamosDeAtividadeHibernate;

@SuppressWarnings("serial")
public class Repositorios implements Serializable {
	
	// Método que retorna a session atual
	private Session getSession() {
		return (Session) FacesUtil.getRequestAttribute("session");
	}

	public Pessoas getPessoas() {
		return new PessoasHibernate(this.getSession());
	}

	public Lancamentos getLancamentos() {
		return new LancamentosHibernate(this.getSession());
	}

	public RamosDeAtividade getRamosDeAtividade() {
		return new RamosDeAtividadeHibernate(this.getSession());
	}

}
