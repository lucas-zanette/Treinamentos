package aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BdFactory {
	private static BdFactory bdFactory = null;
	
	//Método privado do design pattern Singleton.
	private BdFactory() {
		//Inicializo o driver JDBC.
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO AO INICIAR O DRIVER");
			e.printStackTrace();
		}
		
	}
	
	public static BdFactory getInstance() {
		if (bdFactory == null)
			bdFactory = new BdFactory();
		
		return bdFactory;
	}
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/aula?user=root&password=elaborata&useSSL=false");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO AO CRIAR A CONEXÃO");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void inserirPessoa() {
		Connection con = BdFactory.getInstance().getConnection();
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"insert into pessoa (nome, endereco, email) values (?, ?, ?)");

			ps.setString(1, "Ademundo");
			ps.setString(2, "Rua do Ade");
			ps.setString(3, "ade@world.com");

			ps.execute();

			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO AO EXECUTAR COMANDO");
			e.printStackTrace();
		}
	}
	
}


















