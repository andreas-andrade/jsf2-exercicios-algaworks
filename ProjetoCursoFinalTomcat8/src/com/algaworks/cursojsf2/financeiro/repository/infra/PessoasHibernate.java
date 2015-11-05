package com.algaworks.cursojsf2.financeiro.repository.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;

public class PessoasHibernate implements Pessoas{
	private Session session;
	public PessoasHibernate(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> todas() {
		return session.createCriteria(Pessoa.class)
				.addOrder(Order.asc("codigo"))
				.list();
	}

	@Override
	public Pessoa porCodigo(Integer codigo) {
		return (Pessoa) session.get(Pessoa.class, codigo);
	}

	@Override
	public Pessoa guardar(Pessoa pessoa) {
		return (Pessoa) session.merge(pessoa);
	}

	@Override
	public void remover(Pessoa pessoa) {
		this.session.delete(pessoa);
	}
}
