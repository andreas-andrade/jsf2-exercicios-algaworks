package com.algaworks.cursojsf2.converter;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.algaworks.Valor")
public class ValorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {

		if (valor.equals("muito")) {
			return new BigDecimal(10000000);
		} else if (valor.equals("pouco")) {
			return new BigDecimal(500);
		}
		return valor;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
		return objeto.toString();
	}

}
