package com.algaworks.cursojsf2.financeiro.view;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos;
import com.algaworks.cursojsf2.financeiro.service.RegraNegocioException;
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
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.excluir(this.lancamentoSelecionado);
			String msg = "Exclusão efetuada com sucesso";
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, msg);
			this.inicializar();
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}
	}
	
	public void downloadComprovante() throws IOException {
		if (!lancamentoSelecionado.isPago() || lancamentoSelecionado.getComprovante() == null) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Lançamento não tem comprovante");
			return;
		}
		
		String nomeArquivo = "comprovante_" + lancamentoSelecionado.getCodigo() + ".pdf";
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		
		// é importante dar o reset para que dados não seram mesclados indevidamente, alterando as propriedades do arquivo do download
		externalContext.responseReset();
		externalContext.setResponseContentType("application/pdf");
		
		// para o browser começar a fazer o download os parametros abaixo são necessários
		// descomente para habilitar o download do arquivo
		//externalContext.setResponseHeader("Content-Disposition", "attachment; filename\"" + nomeArquivo + "\"");
		// descomente para abrir o arquivo no navegador
		externalContext.setResponseHeader("Content-Disposition", "filename\"" + nomeArquivo + "\"");
		
		// pega o fluxo de saída
		OutputStream out = externalContext.getResponseOutputStream();
		
		// pegar os bytes e enviar para a saída
		try (InputStream is = new ByteArrayInputStream(lancamentoSelecionado.getComprovante())) {
			
			int read = -1;
			byte[] buffer = new byte[1024];
			
			// lê o buffer de 1KB em 1KB e vai gravando em uma saída para enviar para o usuário
			while ((read = is.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
		}
		
		// diz para o JSF que a resposta já está completa, ou seja, ele encerra o ciclo de vida uma vez que o método já o fez.
		context.responseComplete();
	}
}