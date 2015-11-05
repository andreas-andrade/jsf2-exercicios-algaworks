package com.algaworks.cursojsf2.validator;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.algaworks.DataValidator")
public class DataValidator implements Validator {

	@Override
	public void validate(FacesContext contexto, UIComponent componente, Object objeto)
			throws ValidatorException {
		Date dataDigitada = (Date) objeto;
		
		if (dataDigitada.compareTo(Calendar.getInstance().getTime()) == 1) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inválida", "Digita uma data anterior à atual!");
			throw new ValidatorException(msg);
		}
	}

}
