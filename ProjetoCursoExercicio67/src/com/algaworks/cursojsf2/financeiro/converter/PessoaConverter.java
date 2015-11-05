package com.algaworks.cursojsf2.financeiro.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@FacesConverter(forClass=Pessoa.class)
public class PessoaConverter implements Converter{
	Pessoas pessoas = null;
	private Repositorios Repositorios = new Repositorios();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		if (value != null && !value.equals("")) {
			pessoas = Repositorios.getPessoas();
			retorno = pessoas.porCodigo(new Integer(value));
			
			if (retorno == null) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Pessoa não existe!",
						"Pessoa não existe!");
				throw new ConverterException(message);
			}
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
		if (objeto != null) {
			Integer codigo = ((Pessoa) objeto).getCodigo();
			return codigo == null ? "" : codigo.toString();
		}
		return null;
	}
	
}
