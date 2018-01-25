package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) {
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
			e.printStackTrace();
		}
	}

}
