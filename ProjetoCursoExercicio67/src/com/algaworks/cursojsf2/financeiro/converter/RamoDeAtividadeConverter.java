package com.algaworks.cursojsf2.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import com.algaworks.cursojsf2.financeiro.model.RamoAtividade;
import com.algaworks.cursojsf2.financeiro.util.HibernateUtil;

@FacesConverter(forClass=RamoAtividade.class)
public class RamoDeAtividadeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente, String texto) {
		RamoAtividade ramo = null;
		
		if (texto != null) {
			Session session = HibernateUtil.getSession();
			ramo = (RamoAtividade) session.get(RamoAtividade.class, new Integer(texto));
			session.close();
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
