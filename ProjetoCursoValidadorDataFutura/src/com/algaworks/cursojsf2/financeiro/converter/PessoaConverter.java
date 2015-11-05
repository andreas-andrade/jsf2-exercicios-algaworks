package com.algaworks.cursojsf2.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.service.GestaoPessoas;

@FacesConverter(forClass=Pessoa.class)
public class PessoaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
		Pessoa retorno = null;
		if (valor != null) {
			GestaoPessoas gestaoPessoas = new GestaoPessoas();
			retorno = gestaoPessoas.buscarPorCodigo(new Integer(valor));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
		if (objeto!=null) {
			return ((Pessoa) objeto).getCodigo().toString() ;
		}
		return null;
	}
	
}
