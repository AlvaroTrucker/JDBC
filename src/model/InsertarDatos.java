package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatos {
	private static Statement sentencia;
	public static void addUsuario(Connection con, Usuario u){
		//INSERT INTO usuario VALUES (null, "joaquin", 21);
		String sql = "INSERT INTO usuario VALUES "
				+ "(null,"+"'"+u.getNombre()+"'"+","+u.getEdad()+")";
		try {
			sentencia = con.createStatement();
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
