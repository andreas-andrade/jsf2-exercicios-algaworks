package com.algaworks.cursojsf2.financeiro.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.algaworks.cursojsf2.financeiro.model.RamoAtividade;
import com.algaworks.cursojsf2.financeiro.repository.RamosDeAtividade;

public class RamosDeAtividadeHibernate implements RamosDeAtividade{

	Session session;
	public RamosDeAtividadeHibernate(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RamoAtividade> todos() {
		return session.createCriteria(RamoAtividade.class)
				.addOrder(Order.asc("codigo"))
				.list();
	}
	
}
