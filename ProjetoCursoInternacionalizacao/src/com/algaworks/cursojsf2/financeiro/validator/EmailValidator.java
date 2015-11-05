package com.algaworks.cursojsf2.financeiro.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.sun.faces.util.MessageFactory;

@FacesValidator("com.algaworks.EmailValidator")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext contexto, UIComponent componente, Object objeto) throws ValidatorException {
		String padrao = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		String email = (String) objeto;
		Object label = MessageFactory.getLabel(contexto, componente);
		if (!email.equals("") && email != null) {
			if (!email.matches(padrao)) {
				String mensagem = FacesUtil.getMensagemI18N("field") + " " + label + ": " +FacesUtil.getMensagemI18N("invalid_email");
				FacesMessage mensagemDeErro = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
				throw new ValidatorException(mensagemDeErro);
			}
		}
	}
	
}
