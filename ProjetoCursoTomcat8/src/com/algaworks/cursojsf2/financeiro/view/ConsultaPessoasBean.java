package com.algaworks.cursojsf2.financeiro.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.service.GestaoPessoas;
import com.algaworks.cursojsf2.financeiro.service.RegraNegocioException;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@ManagedBean
public class ConsultaPessoasBean {
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Repositorios repositorios = new Repositorios(); 
	private Pessoa pessoaSelecionada;
	
	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	@PostConstruct
	public void inicializar() {
		GestaoPessoas gestaoPessoas = new GestaoPessoas(this.repositorios.getPessoas(), this.repositorios.getLancamentos());
		pessoas = gestaoPessoas.listar();
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public void excluir() {
		GestaoPessoas gestaoPessoas = new GestaoPessoas(this.repositorios.getPessoas(), this.repositorios.getLancamentos());
		try {
			gestaoPessoas.excluir(pessoaSelecionada);
			String msg = "Exclusão efetuada com sucesso";
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, msg);
			this.inicializar();
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
}
