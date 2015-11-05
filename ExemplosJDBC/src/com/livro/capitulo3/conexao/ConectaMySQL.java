package com.livro.capitulo3.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaMySQL {
	public static void main(String[] args){
		Connection conexao = null;
		try {
			//Registrando a classe JDBC em tempo de execução.
			String url = "jdbc:mysql://localhost:3307/agenda";
			//String url = "jdbc:postgresql://localhost:3306/sismed";
			/*
			 * A string de conexao jdbc abaixo foi extraída do próprio MySQL Workbench
			 * jdbc:mysql://localhost:3307/?user=root
			 * 
			 */
			String usuario = "root";
			String senha = "";
			/*
			 * A configuraçao abaixo serve para conectar no PostgreSQL
			 */
			/*String usuario = "sismed";
			String senha = "iwg2pacs";*/
					
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectou!");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro de SQL. Erro: " + e.getMessage());
		} finally {

			try {
				conexao.close();
			} catch (Exception e) {
				System.out.println("Erro ao fechar a conexão. Erro: "
						+ e.getMessage());
			}
		}
	}
}
