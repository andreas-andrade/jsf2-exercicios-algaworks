package com.algaworks.cursojsf2.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.util.HibernateUtil;

@FacesConverter(forClass=Pessoa.class)
public class PessoaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
		Pessoa retorno = null;
		if (valor != null) {
			Session session = HibernateUtil.getSession();
			/*
			 * O método load da session busca por um objeto de acordo com os parâmetros passados.
			 * Neste caso, será buscada uma pessoa com o código = valor.
			 */
			retorno = (Pessoa) session.get(Pessoa.class, new Integer(valor));
			session.close();
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
		if (objeto != null) {
			return ((Pessoa) objeto).getCodigo().toString() ;
		}
		return null;
	}
	
}
