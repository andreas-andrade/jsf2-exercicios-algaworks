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
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;
import com.algaworks.cursojsf2.financeiro.repository.RamosDeAtividade;
import com.algaworks.cursojsf2.financeiro.service.GestaoRamosDeAtividade;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroPessoaBean implements Serializable{

	private Repositorios repositorios = new Repositorios();
	private Boolean deveRenderizarRamoDeAtividade;
	private Boolean deveRenderizarDataDeNasc;
	
	public Boolean getDeveRenderizarRamoDeAtividade() {
		return deveRenderizarRamoDeAtividade;
	}

	public Boolean getDeveRenderizarDataDeNasc() {
		return deveRenderizarDataDeNasc;
	}


	public List<RamoAtividade> listaDeRamosDeAtividade = new ArrayList<RamoAtividade>();
	
	private Pessoa pessoa = new Pessoa();
	
	@PostConstruct
	public void init() {
		// Aqui foi o único lugar onde eu implementei o buscar todos na classe de negócios. Só para testar...
		GestaoRamosDeAtividade gestaoAtividades = new GestaoRamosDeAtividade(this.repositorios.getRamosDeAtividade());
		gestaoAtividades.listar();
	}

	public List<RamoAtividade> getRamosDeAtividade() {
		return listaDeRamosDeAtividade;
	}

	public void setRamosDeAtividade(List<RamoAtividade> ramosDeAtividade) {
		this.listaDeRamosDeAtividade = ramosDeAtividade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void Cadastrar() {
		Pessoas pessoas = repositorios.getPessoas();
		
		try {
			pessoas.guardar(pessoa);
			this.pessoa = new Pessoa();
			String msg = "Cadastro efetuado com sucesso!";
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, msg);
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Deu erro!!!!!!!!!" + ex.getMessage());
		}
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
