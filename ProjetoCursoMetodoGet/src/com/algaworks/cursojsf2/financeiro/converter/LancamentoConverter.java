package com.algaworks.cursojsf2.financeiro.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.Convert;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@FacesConverter(forClass=Lancamento.class)
public class LancamentoConverter implements Converter{
	private Repositorios repositorios = new Repositorios();
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Lancamento retorno = null;
		Lancamentos lancamentos = repositorios.getLancamentos();
		if (value != null && !value.equals("")) {
			retorno = lancamentos.porCodigo(new Integer(value));
			
			if (retorno == null) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Lançamento não existe!",
						"Lançamento não existe!");
				throw new ConverterException(message);
			}
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if (object != null) {
			Integer codigo = ((Lancamento) object).getCodigo();
			return codigo == null ? "" : codigo.toString();
		}
		return null;
	}

}
