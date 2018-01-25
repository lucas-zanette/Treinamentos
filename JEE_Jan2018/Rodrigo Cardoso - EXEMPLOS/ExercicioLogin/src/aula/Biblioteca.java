package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Biblioteca {
	public static Connection getConnection() {
		//Recupera uma das conexões do AppServer.
		try {
			InitialContext initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:/comp/env/jdbc/exercicio");
			return ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Método usado para executar comandos SQL de forma automatizada.
	public static ResultSet execSql(Connection con, String sql, Object...param) {
		try {
			//Prepara o comando SQL.
			PreparedStatement ps = con.prepareStatement(sql);
			
			//Caso hajam parâmetros para substituir os sinais de interrogação (?) do comando SQL,
			//faz a substituição conforme o tipo de cada valor.
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					if (param[i] instanceof Integer)
						ps.setInt(i + 1, (Integer) param[i]);
					else if (param[i] instanceof Double)
						ps.setDouble(i + 1, (Double) param[i]);
					else if (param[i] instanceof Boolean)
						ps.setBoolean(i + 1, (Boolean) param[i]);
					else if (param[i] instanceof String)
						ps.setString(i + 1, (String) param[i]);
					else
						ps.setObject(i + 1, param[i]);
				}
			}

			//Executa o comando SQL recuperando o ResultSet quando for um SELECT, ou apenas
			//executa sem recuperar retorno em caso de outros comandos, como UPDATE, INSERT, DELETE, etc.
			ResultSet rs = null;
			if (sql.trim().split(" ")[0].toLowerCase().equals("select"))
				rs = ps.executeQuery();
			else
				ps.execute();
			
			//Retorna o valor para quem chamou a função.
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
