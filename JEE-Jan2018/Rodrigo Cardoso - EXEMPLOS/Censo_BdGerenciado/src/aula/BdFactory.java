package aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BdFactory {
	private static BdFactory bdFactory = null;
	
	//Construtor privado, conforme design pattern Singleton.
	private BdFactory() {
	}

	//Recupera a única instância possível do objeto.
	public static BdFactory getInstance() {
		if (bdFactory == null)
			bdFactory = new BdFactory();
		
		return bdFactory;
	}

	//Cria uma nova conexão com o banco de dados.
	private Connection criaNovaConexao() {
		//Recupera uma das conexões do AppServer.
		InitialContext initCtx;
		try {
			initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:/comp/env/jdbc/censo-ds");
			Connection con = ds.getConnection();
			return con;
		} catch (NamingException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	
	//Retorna uma conexão com o banco de dados.
	public static Connection getConnection() {
		return getInstance().criaNovaConexao();
	}

	//Executa um comando SQL qualquer, e caso seja um SELECT, retorna o resultado.
	public ResultSet execSql(String sql, Object...param) {
		try {
			Connection con = getConnection();
			ResultSet resposta = execSqlPrivada(con, sql, param);
			con.close();
			return resposta;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//Executa um comando SQL qualquer USANDO A CONEXÃO FORNECIDA, e caso seja um SELECT, retorna o resultado.
	public ResultSet execSql(Connection con, String sql, Object...param) {
		return execSqlPrivada(con, sql, param);
	}

	//Executa um comando SELECT, e caso o resultado não seja vazio, recupera o primeiro campo do primeiro registro,
	//o que pode ser usado em casos de comando que recuperam apenas um valor, como MAX, SUM, Last_Insert_ID(), etc.
	public Object execSelect(Connection con, String sql, Object...param) {
		try {
			ResultSet rs = execSqlPrivada(con, sql, param);
			if (rs.next()) {
				return rs.getObject(1);
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//Método privado usado para executar comandos SQL de forma automatizada.
	private ResultSet execSqlPrivada(Connection con, String sql, Object[] param) {
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

























