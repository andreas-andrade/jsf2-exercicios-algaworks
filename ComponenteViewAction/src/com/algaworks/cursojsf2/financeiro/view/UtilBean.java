package com.algaworks.cursojsf2.financeiro.view;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class UtilBean {
	public String getServletPath(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		return request.getServletPath();
	}
	
	public String getURI(String uri){
		if( uri.equals( getServletPath())){
			return "active";
		}
		return "";
	}
}
