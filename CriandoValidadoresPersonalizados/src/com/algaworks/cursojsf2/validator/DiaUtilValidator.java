package com.algaworks.cursojsf2.validator;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.algaworks.DiaUtil")
public class DiaUtilValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent componente, Object valor)
			throws ValidatorException {
		Calendar data = Calendar.getInstance();
		data.setTime((Date) valor);
		 
		int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);
		
		if (diaDaSemana == Calendar.SATURDAY || diaDaSemana == Calendar.SUNDAY) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Data não permitida",
					"Sábados e domingos não são permitidos!");
			throw new ValidatorException(msg);
		}
	}

}
