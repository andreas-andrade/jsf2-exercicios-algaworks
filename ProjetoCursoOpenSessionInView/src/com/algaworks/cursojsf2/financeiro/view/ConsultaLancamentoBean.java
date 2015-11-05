package com.algaworks.cursojsf2.financeiro.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;


@ManagedBean
public class ConsultaLancamentoBean {

	private Repositorios repositorios = new Repositorios();
	private List<Lancamento> listaDeLancamentos = new ArrayList<Lancamento>();
	
	private Lancamento lancamentoSelecionado;
	
	@PostConstruct
	public void inicializar() {
		Lancamentos lancamentos = this.repositorios.getLancamentos();
		this.listaDeLancamentos = lancamentos.todos();
	}
	
	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}


	public List<Lancamento> getLancamentos() {
		return listaDeLancamentos;
	}
	
	public void excluir() {
		if (this.lancamentoSelecionado.isPago()) {
			String msg = "Lançamento já foi pago e não pode ser excluído!";
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, msg);
		} else {
			Lancamentos lancamentos = this.repositorios.getLancamentos();
			lancamentos.remover(this.lancamentoSelecionado);
			
			String msg = "Exclusão efetuada com sucesso";
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, msg);

			this.inicializar();

			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, msg);
		}
	}
}