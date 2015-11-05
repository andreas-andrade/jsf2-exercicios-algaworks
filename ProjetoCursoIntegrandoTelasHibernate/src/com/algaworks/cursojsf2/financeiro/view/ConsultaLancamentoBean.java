package com.algaworks.cursojsf2.financeiro.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.util.HibernateUtil;

@ManagedBean
public class ConsultaLancamentoBean {

	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	
	@PostConstruct
	public void inicializar() {
		Session session = HibernateUtil.getSession();
		lancamentos = session.createCriteria(Lancamento.class)
				.addOrder(Order.desc("dataVencimento"))
				.list();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
}