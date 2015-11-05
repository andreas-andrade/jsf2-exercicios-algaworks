package com.algaworks.cursojsf2.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.cursojsf2.financeiro.model.RamoAtividade;
import com.algaworks.cursojsf2.financeiro.service.GestaoRamoAtividade;

@FacesConverter(forClass=RamoAtividade.class)
public class RamoDeAtividadeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente, String texto) {
		RamoAtividade ramo = null;
		
		if (texto != null) {
			GestaoRamoAtividade gestao = new GestaoRamoAtividade();
			ramo = (gestao.buscarPorCodigo(new Integer(texto)));
		}
		return ramo;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
		if (objeto != null) {
			RamoAtividade ramo = (RamoAtividade) objeto;
			return ramo.getCodigo().toString();
			//return ramo.getDescricao();
		}
		return null;
	}

}
