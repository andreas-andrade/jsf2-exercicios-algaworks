package com.algaworks.cursojsf2.financeiro.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.sun.faces.util.MessageFactory;

@FacesValidator("com.algaworks.Comprovante")
public class ComprovanteValidator implements Validator {

	@Override
	public void validate(FacesContext contexto, UIComponent componente, Object objeto) throws ValidatorException {
		
		Part arquivo = (Part) objeto;

		if (arquivo != null && !arquivo.getContentType().equals("application/pdf")) {
			// o objeto abaixo armazanará o label do componente que está sendo validado
			Object label = MessageFactory.getLabel(contexto, componente);
			String mensagemDeErro = label + ": "  + FacesUtil.getMensagemI18N("is_not_a_proper_file");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagemDeErro, mensagemDeErro);
			throw new ValidatorException(msg);
		}
	}

}
