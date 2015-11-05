package com.algaworks.cursojsf2.financeiro.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.sun.faces.util.MessageFactory;

@FacesValidator("com.algaworks.ValidadorCondicional")
public class ValidadorCondicionalValidator implements Validator{

	@Override
	public void validate(FacesContext contexto, UIComponent componente, Object objeto) throws ValidatorException {
		Boolean checado = (Boolean) componente.getAttributes().get("checado");

		if (objeto == null && checado != null && checado) {
			Object label = MessageFactory.getLabel(contexto, componente);
			String descricaoErro = FacesUtil.getMensagemI18N("fill_the_field") + ": "  + label + " .";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, descricaoErro, descricaoErro);
			throw new ValidatorException(message);
		}
	}

}
