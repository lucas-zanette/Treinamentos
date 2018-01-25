package aula;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Biblioteca {
	
	//Salva na sessão todos os parâmetros que foram recebidos do request.
	public static void salvaParamNaSessao(HttpSession session, HttpServletRequest request) {
		Enumeration en = request.getParameterNames();
		
		while (en.hasMoreElements()) {
			String nomeParam = en.nextElement().toString();
			session.setAttribute(nomeParam, request.getParameter(nomeParam));
		}	
	}
	
	//Método ao estilo "façade", ou seja, que faz a chamada de vários outros métodos, a fim de executar
	//uma operação complexa com apenas uma chamada de função.
	public static int salvaCenso(HttpSession session) {
		//Salva a pessoa.
		Connection con = BdFactory.getConnection();
		int codPessoa = salvaPessoa(con, session.getAttribute("nome").toString(), session.getAttribute("endereco").toString(), session.getAttribute("email").toString());
		
		//Salva apenas os eletrodomésticos que estiverem preenchidos.
		if (!session.getAttribute("EletroNome1").toString().equals(""))
			salvaEletro(con, session.getAttribute("EletroNome1").toString(), convInt(session.getAttribute("EletroQtd1").toString()), codPessoa);
		if (!session.getAttribute("EletroNome2").toString().equals(""))
			salvaEletro(con, session.getAttribute("EletroNome2").toString(), convInt(session.getAttribute("EletroQtd2").toString()), codPessoa);
		if (!session.getAttribute("EletroNome3").toString().equals(""))
			salvaEletro(con, session.getAttribute("EletroNome3").toString(), convInt(session.getAttribute("EletroQtd3").toString()), codPessoa);

		//Salva apenas os pets que estiverem preenchidos.
		if (!session.getAttribute("PetNome1").toString().equals(""))
			salvaPet(con, session.getAttribute("PetNome1").toString(), session.getAttribute("PetEspecie1").toString(), session.getAttribute("PetRaca1").toString(), codPessoa);
		if (!session.getAttribute("PetNome2").toString().equals(""))
			salvaPet(con, session.getAttribute("PetNome2").toString(), session.getAttribute("PetEspecie2").toString(), session.getAttribute("PetRaca2").toString(), codPessoa);
		if (!session.getAttribute("PetNome3").toString().equals(""))
			salvaPet(con, session.getAttribute("PetNome3").toString(), session.getAttribute("PetEspecie3").toString(), session.getAttribute("PetRaca3").toString(), codPessoa);
		
		return codPessoa;
	}
	
	//Recebe uma string que pode estar mal formatada, e transforma em um int.
	private static int convInt(String s) {
		try {
			return ( (s == null) || (s.equals("")) ) ? 0 : Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

	public static int salvaPessoa(Connection con, String nome, String endereco, String email) {
		BdFactory bd = BdFactory.getInstance();
		bd.execSql(con, "insert into pessoa (nome, endereco, email) values (?, ?, ?)", nome, endereco, email);
		return ((BigInteger) bd.execSelect(con, "select last_insert_id()")).intValue();
	}
	
	public static int old_salvaPessoa(Connection con, String nome, String endereco, String email) {
		try {
			//Salva a pessoa.
			String sql = "insert into pessoa (nome, endereco, email) values (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, endereco);
			ps.setString(3, email);
			ps.execute();
			
			//Recupera o ID gerado pelo banco de dados.
			ps = con.prepareStatement("select last_insert_id()");
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			return rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	public static void salvaEletro(Connection con, String nome, int qtd, int codPessoa) {
		try {
			String sql = "insert into eletro (nome, qtd, codPessoa) values (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, qtd);
			ps.setInt(3, codPessoa);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void salvaPet(Connection con, String nome, String especie, String raca, int codPessoa) {
		try {
			String sql = "insert into pet (nome, especie, raca, codPessoa) values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, especie);
			ps.setString(3, raca);
			ps.setInt(4, codPessoa);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
