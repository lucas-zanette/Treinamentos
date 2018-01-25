package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
	
	//construtor padrao
	//public Db(){
	
	//não quero que seja instanciada duas vezes
	//private Db() { 
	
	/*
	private Db(){		
	}
	public static Db criar(){		
	}
	*/
		
	private static Db db;
	private Connection con;
	
	private Db() {
		//construtor privado do design pattern Singleton.
		try {
			//pesquisar no google o CONECTION STRING PARA O BANCO ESPECÍFICO
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aula?user=root&password=elaborata&useSSL=false");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			System.out.println("Não foi possível conectar no bd");
			e.printStackTrace();
		}		
	}
	
	public static Db GetInstance() {
		if (db == null) 
			db = new Db();		
		return db;
	}
	
	public Connection getConnection(){
		return con;
	}
}
