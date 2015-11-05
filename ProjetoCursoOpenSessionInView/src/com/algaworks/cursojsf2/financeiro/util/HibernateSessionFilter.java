package com.algaworks.cursojsf2.financeiro.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.Transaction;

@WebFilter(servletNames={"Faces Servlet"})
public class HibernateSessionFilter implements Filter{


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Session session = HibernateUtil.getSession(); 
		Transaction trx = null;
		
		try {
			trx = session.beginTransaction();
			// coloca uma variável no request que guarda a session do hibernate
			request.setAttribute("session", session);
			// O método abaixo dá continuidade à requisição;
			chain.doFilter(request, response);

			trx.commit();

		} catch (Exception e) {
			if (trx != null) {
				trx.rollback();
			}
		} finally {
			// obrigatoriamente devemos fechar a sessão.
			session.close();
		}
		
	}

	@Override
	public void init(FilterConfig init) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		
	}

}
