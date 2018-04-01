/**
 * 
 */
package br.com.base.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author professor
 *
 */
public class Conection {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/base", "root", "");
		System.out.println("Conectado!");
		conexao.close();
	}
	
	public Connection getConnection() throws SQLException {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/base", "root", "");
		 return conexao;
	}
}
