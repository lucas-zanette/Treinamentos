package control;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BD_Gerenciado {

	public static Connection getConnection(){
		
		InitialContext iniCtx;
		
		try {
			iniCtx = new InitialContext();
			DataSource ds = (DataSource) iniCtx.lookup("java:/comp/env/jdbc/exemplo-ds");
			Connection conn = ds.getConnection();			
			return conn;
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
