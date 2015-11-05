package com.algaworks.cursojsf2.financeiro.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.HibernateUtil;

@ManagedBean
public class ConsultaLancamentoBean {

	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	
	private Lancamento lancamentoSelecionado;
	
	
	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

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
	
	public void excluir() {
		if (this.lancamentoSelecionado.isPago()) {
			String msg = "Lançamento já foi pago e não pode ser excluído!";
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, msg);
		} else {
			Session session = HibernateUtil.getSession();
			Transaction trx = session.beginTransaction();
			session.delete(this.lancamentoSelecionado);
			trx.commit();
			session.close();
			String msg = "Exclusão efetuada com sucesso";
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, msg);
			
			this.inicializar();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Exclusão efetuada com sucesso", "Exclusão efetuada com sucesso"));
		}
	}
}