package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.service.GestaoPessoas;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable{
	
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	private Lancamento lancamento = new Lancamento();
	
	@PostConstruct
	public void init() {
		GestaoPessoas gestaoPessoas = new GestaoPessoas();
		this.pessoas = gestaoPessoas.listarTodas();
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	
	public void cadastrar() {
		
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Tipo: " + this.lancamento.getTipo());
		System.out.println("Pessoa: " + this.lancamento.getPessoa().getNome());
		System.out.println("Descrição: " + this.lancamento.getDescricao());
		System.out.println("Valor: " + this.lancamento.getValor());
		System.out.println("Data vencimento: " + formatarData.format(this.lancamento.getDataVencimento()));
		System.out.println("Conta paga: " + this.lancamento.isPago());
		System.out.println("Data pagamento: " + this.lancamento.getDataPagamento());

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
