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

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.RamoAtividade;
import com.algaworks.cursojsf2.financeiro.model.TipoPessoa;
import com.algaworks.cursojsf2.financeiro.service.GestaoRamoAtividade;

@ManagedBean
@ViewScoped
public class CadastroPessoaBean implements Serializable{

	private Boolean deveRenderizarRamoDeAtividade;
	private Boolean deveRenderizarDataDeNasc;
	
	public Boolean getDeveRenderizarRamoDeAtividade() {
		return deveRenderizarRamoDeAtividade;
	}

	public Boolean getDeveRenderizarDataDeNasc() {
		return deveRenderizarDataDeNasc;
	}


	public List<RamoAtividade> ramosDeAtividade = new ArrayList<RamoAtividade>();
	
	private Pessoa pessoa = new Pessoa();
	
	@PostConstruct
	public void init() {
		GestaoRamoAtividade gestaoRamoDeAtividade = new GestaoRamoAtividade();
		this.setRamosDeAtividade(gestaoRamoDeAtividade.listarTodas());
		
	}

	public List<RamoAtividade> getRamosDeAtividade() {
		return ramosDeAtividade;
	}

	public void setRamosDeAtividade(List<RamoAtividade> ramosDeAtividade) {
		this.ramosDeAtividade = ramosDeAtividade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void Cadastrar() {
		System.out.println("Código: " + this.pessoa.getCodigo());
		System.out.println("Nome: " + this.pessoa.getNome());
		System.out.println("Tipo: " + this.pessoa.getTipo());
		System.out.println("E-mail: " + this.pessoa.getEmail());
		if (this.pessoa.getRamoDeAtividade() != null) {
			System.out.println("Ramo de Atividade: " + this.pessoa.getRamoDeAtividade().getDescricao());
		}
		if (this.pessoa.getDataDeNascimento() != null) {
			System.out.println("Data de Nascimento: " + this.pessoa.getDataDeNascimento());
		}
		
		this.pessoa = new Pessoa();
		String msg = "Cadastro efetuado com sucesso!";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public TipoPessoa[] getTiposDePessoa() {
		return TipoPessoa.values();
	}
	
	public Boolean getMostrarRamoDeAtividade() {
		if (this.pessoa.getTipo() == TipoPessoa.FISICA) {
			System.out.println(true);
			return true;
		}
		System.out.println(false);
		return false;
	}
	

	public void tipoListener(ValueChangeEvent event) {
		if (event.getNewValue().toString() == "FISICA") {
			deveRenderizarRamoDeAtividade = false;
			deveRenderizarDataDeNasc = true;
		} else {
			deveRenderizarRamoDeAtividade = true;
			deveRenderizarDataDeNasc = false;
		}
		FacesContext.getCurrentInstance().renderResponse();
	}
}
