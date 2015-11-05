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
import com.algaworks.cursojsf2.financeiro.service.GestaoRamosDeAtividade;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroPessoaBean implements Serializable{

	private Repositorios repositorios = new Repositorios();
	private Pessoa pessoa = new Pessoa();
	public List<RamoAtividade> listaDeRamosDeAtividade = new ArrayList<RamoAtividade>();
	
	@PostConstruct
	public void init() {
		// Aqui foi o único lugar onde eu implementei o buscar todos na classe de negócios. Só para testar...
		GestaoRamosDeAtividade gestaoAtividades = new GestaoRamosDeAtividade(this.repositorios.getRamosDeAtividade());
		listaDeRamosDeAtividade = gestaoAtividades.listar();
		System.out.println("================================");
		System.out.println("valor do bean TIPO: " + this.pessoa.getTipo());
		System.out.println("valor do bean NOME: " + this.pessoa.getNome());
		System.out.println("valor do bean EMAIL: " + this.pessoa.getEmail());
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
		if (this.pessoa == null) {
			this.pessoa = new Pessoa();
		}
	}

	public String salvar() {
		Pessoas pessoas = repositorios.getPessoas();
		
		try {
			pessoas.guardar(pessoa);
			this.pessoa = new Pessoa();
			String msg = "Cadastro efetuado com sucesso!";
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, msg);
			return "";
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Deu erro!!!!!!!!!" + ex.getMessage());
		}
		return "";
	}
	
	public TipoPessoa[] getTiposDePessoa() {
		return TipoPessoa.values();
	}

	public void tipoListener(ValueChangeEvent event) {
		if (event.getNewValue().toString() == "FISICA") {
			pessoa.setTipo(TipoPessoa.FISICA);
		} else {
			pessoa.setTipo(TipoPessoa.JURIDICA);
		}
		System.out.println("---------------------------------------------------------");
		System.out.println("valor do elemento: " + event.getNewValue().toString());
		System.out.println("valor do bean: " + this.pessoa.getTipo());
		FacesContext.getCurrentInstance().renderResponse();
	}
}
