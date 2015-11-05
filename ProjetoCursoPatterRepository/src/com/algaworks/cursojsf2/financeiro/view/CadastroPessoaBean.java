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
import org.hibernate.Transaction;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.RamoAtividade;
import com.algaworks.cursojsf2.financeiro.model.TipoPessoa;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.HibernateUtil;

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
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		Session session = HibernateUtil.getSession();
		ramosDeAtividade = session.createCriteria(RamoAtividade.class).list();
		
		session.close();
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
		try {
			Session session = HibernateUtil.getSession();
			Transaction transac = session.beginTransaction();
			session.merge(this.pessoa);

			transac.commit();
			session.close();

			this.pessoa = new Pessoa();
			String msg = "Cadastro efetuado com sucesso!";
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
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
