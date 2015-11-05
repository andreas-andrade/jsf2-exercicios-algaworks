package com.algaworks.cursojsf2.financeiro.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.sun.faces.util.MessageFactory;

@FacesValidator("com.algaworks.DataFutura")
public class DataFuturaValidator implements Validator {

	@Override
	public void validate(FacesContext contexto, UIComponent componente, Object objeto) throws ValidatorException {
		
		Date dataDigitada = (Date) objeto;

		if (dataDigitada!=null && dataDigitada.after(new Date())) {
			// o objeto abaixo armazanará o label do componente que está sendo validado
			Object label = MessageFactory.getLabel(contexto, componente);
			String mensagemDeErro = label + ": "  + FacesUtil.getMensagemI18N("cannot_be_a_future_date");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagemDeErro, mensagemDeErro);
			throw new ValidatorException(msg);
		}
	}

}
