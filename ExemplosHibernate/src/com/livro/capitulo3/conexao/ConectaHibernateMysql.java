package com.livro.capitulo3.conexao;

import org.hibernate.Session;

public class ConectaHibernateMysql {
	public static void main(String[] args) {
		Session sessao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			System.out.println(" Varian Conectou!");
		} catch (Exception e) {
			System.out.println("Ocorreu algum problema na conexão. Erro: " + e.getMessage());
		} finally {
			sessao.close();
		}
	}
}	
