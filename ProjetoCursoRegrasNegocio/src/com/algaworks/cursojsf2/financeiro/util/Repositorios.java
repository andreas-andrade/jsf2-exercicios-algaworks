package com.algaworks.cursojsf2.financeiro.util;

import java.io.Serializable;

import org.hibernate.Session;

import com.algaworks.cursojsf2.financeiro.infra.LancamentosHibernate;
import com.algaworks.cursojsf2.financeiro.infra.PessoasHibernate;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;

public class Repositorios implements Serializable{
	public Pessoas getPessoas() {
		return new PessoasHibernate(this.getSession());
	}
	
	public Lancamentos getLancamentos() {
		return new LancamentosHibernate(this.getSession());
	}
	
	private Session getSession() {
		return (Session) FacesUtil.getRequestAttribute("session");
	}
}
