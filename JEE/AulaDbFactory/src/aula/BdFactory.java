package aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdFactory {
	
	private static BdFactory bdfactory;  //maiuscula e'a classe minusculo a instancia
	
	private BdFactory() {
		//Metodo privado do design pattern Singleton.
		//inicializo o driver JDBC
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	public static BdFactory getInstance() {
		if (bdfactory == null) 
			bdfactory = new BdFactory();			
		
		return bdfactory;		
	}
	
	public Connection getConnection(){
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aula?user=root&password=elaborata&useSSL=false");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
