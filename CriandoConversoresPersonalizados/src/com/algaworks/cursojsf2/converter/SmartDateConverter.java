package com.algaworks.cursojsf2.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

// implementando conversores personalizados. Cap 4 Aula 8 do curso

@FacesConverter("com.algaworks.SmartDate")
public class SmartDateConverter implements Converter{

	/*
	 * o método abaixo retorna um objeto Date a partir de uma string ou o contrário.
	 */
	private static final DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date getDataDeHoje() {
		
		Calendar dataDeHoje = Calendar.getInstance();
		
		dataDeHoje.set(Calendar.HOUR_OF_DAY, 0);
		dataDeHoje.set(Calendar.MINUTE, 0);
		dataDeHoje.set(Calendar.SECOND, 0);
		dataDeHoje.set(Calendar.MILLISECOND, 0);
		
		return dataDeHoje.getTime();
	}
	
	/*
	 * O método abaixo captura o que for digitado no componente e faz as transformações necessárias.
	 * Se for uma data normal, ele a devolve, mas se for um snippet, ele transforma. Exemplo: "hoje" ele devolve a data atual
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent componente, String valor) {
		Date dataConvertida = null;
		if (valor != null && !valor.equals("")) {
			if (valor.equalsIgnoreCase("hoje")) {
				dataConvertida = getDataDeHoje();
			} else {
				 try {
					dataConvertida = formatador.parse(valor);
				} catch (ParseException e) {
					/*
					 * Devemos criar uma exceção que lança um objeto do tipo FacesMessage e o coloca na fila de mensagens de erro.
					 */
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data incorreta", "Informe uma data correta");
					throw new ConverterException(msg);
				}
			}
		}
		return dataConvertida;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componente, Object valor) {
		if (valor.equals(getDataDeHoje())){
			return "hoje";
		}
		return formatador.format((Date) valor);
		
	}
	
}
