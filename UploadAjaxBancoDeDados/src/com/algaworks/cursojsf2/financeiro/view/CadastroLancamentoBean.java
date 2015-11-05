package com.algaworks.cursojsf2.financeiro.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.Part;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;
import com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos;
import com.algaworks.cursojsf2.financeiro.service.RegraNegocioException;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable{
	
	private Repositorios repositorios = new Repositorios();
	private List<Pessoa> listaDePessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();
	private transient Part arquivoComprovante;
	
	public String init() {
		if (lancamento.isPago()) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, 
					"Lançamentos pagos não podem ser editados.");
			return "consulta_lancamento";
		}
		// null retorna para mesma página
		Pessoas pessoas = this.repositorios.getPessoas();
		listaDePessoas = pessoas.todas();
		System.out.println("Arquivo: " + lancamento.getComprovante());
		return null;
	}
	
	public Part getArquivoComprovante() {
		return arquivoComprovante;
	}

	public void setArquivoComprovante(Part arquivoComprovante) {
		this.arquivoComprovante = arquivoComprovante;
	}

	public void setLancamento(Lancamento lancamento) throws CloneNotSupportedException {
		this.lancamento = lancamento;
		if (this.lancamento == null) {
			this.lancamento = new Lancamento();
		} else {
			this.lancamento = (Lancamento) lancamento.clone();
		}
	}

	public List<Pessoa> getPessoas() {
		return listaDePessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.listaDePessoas = pessoas;
	}

	public void uploadComprovante(ActionEvent event) {
		if (arquivoComprovante != null) {
			try (InputStream is = arquivoComprovante.getInputStream();
					ByteArrayOutputStream out = new ByteArrayOutputStream()){
				int read = -1;
				byte[] buffer = new byte[1024];
				
				while ((read = is.read(buffer)) != -1) {
					out.write(buffer, 0, read);
				}
				
				lancamento.setComprovante(out.toByteArray());
			} catch (IOException e) {
				throw new RuntimeException("Erro ao enviar arquivo", e);
			}
		}
	}
	
	public void salvar() {
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.salvar(lancamento);
			this.lancamento = new Lancamento();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18N("entry_saved"));
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, FacesUtil.getMensagemI18N(e.getMessage()));
		}
		
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
	
	public boolean isEditando() {
		return this.lancamento.getCodigo() != null;
	}
	
	public String checarPagamento(){
		if (lancamento.isPago()) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, 
					"Lançamentos pagos não podem ser editados.");
			return "consulta_lancamento";
		}
		// null retorna para mesma página
		return null;
	}
}
