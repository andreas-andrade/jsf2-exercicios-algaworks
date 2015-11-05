package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable{
	
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	private Lancamento lancamento = new Lancamento();
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		// buscando o request.
		Session session = (Session) FacesUtil.getRequestAttribute("session");
		
		this.pessoas = session.createCriteria(Pessoa.class)
				.addOrder(Order.asc("codigo"))
				.list();
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	
	public void cadastrar() {
		
		Session session = (Session) FacesUtil.getRequestAttribute("session");
		
		// MUDEI AQUI DE PERSIST PARA MERGE	
		session.merge(this.lancamento);
		
		this.lancamento = new Lancamento();
		
		String msg = "Cadastro efetuado com sucesso!";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	public Lancamento getLancamento() {
		return lancamento;
	}

	public TipoLancamento[] getTiposLancamentos() {
		 return TipoLancamento.values();
	}
	
	/*
	 * este método captura a mudança de valor do checkbox Conta Paga. Quando ocorre esta mudança, o valor é imediatamente salvo no bean
	 */
	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setDataPagamento(null);
		this.lancamento.setPago((Boolean) event.getNewValue());
		// o comando abaixo força o servidor a "pular" para a fase de renderização da página, deixando de validar os outros elementos, e, assim, as mensagens
		// de erro de validação nao aparecem
		FacesContext.getCurrentInstance().renderResponse();
	}
	
}
