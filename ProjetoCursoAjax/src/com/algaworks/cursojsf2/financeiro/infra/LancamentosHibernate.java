package com.algaworks.cursojsf2.financeiro.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;

/*
 * CLASSE QUE IMPLEMENTA AS REGRAS DO DOMÍNIO DO SISTEMA
 */
public class LancamentosHibernate implements Lancamentos{

	private Session session;
	
	public LancamentosHibernate(Session session){
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> todos() {
		return session.createCriteria(Lancamento.class)
				.addOrder(Order.desc("dataVencimento"))
				.list();
	}

	@Override
	public Lancamento guardar(Lancamento lancamento) {
		return (Lancamento) session.merge(lancamento);
	}

	@Override
	public void remover(Lancamento lancamento) {
		this.session.delete(lancamento);
	}

	@Override
	public Lancamento comDadosIguais(Lancamento lancamento) {
		return (Lancamento) this.session.createCriteria(Lancamento.class)
				.add(Restrictions.eq("tipo", lancamento.getTipo()))
				.add(Restrictions.eq("pessoa", lancamento.getPessoa()))
				.add(Restrictions.ilike("descricao", lancamento.getDescricao()))
				.add(Restrictions.eq("valor", lancamento.getValor()))
				.add(Restrictions.eq("dataVencimento", lancamento.getDataVencimento()))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> pesquisarLancamentosDePessoas(Pessoa pessoa) {
		return this.session.createCriteria(Lancamento.class)
				.add(Restrictions.eq("pessoa", pessoa))
				.list();
	}
	
	/*public Long totalPor(Pessoa pessoa) {
		return (Long) session.createCriteria(Lancamento.class)
				.add(Restrictions.eq("pessoa", pessoa))
				.setProjection(Projections.rowCount()).uniqueResult();
	}*/

	public boolean existemPara(Pessoa pessoa) {
		return this.pesquisarLancamentosDePessoas(pessoa).size() > 0;
	}

	@Override
	public Lancamento porCodigo(Integer codigo) {
		return (Lancamento) session.createCriteria(Lancamento.class)
				.add(Restrictions.eqOrIsNull("codigo", codigo))
				.uniqueResult();
	}

}
