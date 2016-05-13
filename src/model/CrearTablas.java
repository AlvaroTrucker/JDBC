package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTablas {
	private static Statement sentencia;
	public static void crearTablaUsuario(Connection con){
		//creamos la sentencia como un String
		String sql0 = "DROP TABLE IF EXISTS usuario";
		String sql1 = "CREATE TABLE usuario( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "nombre TEXT,"
				+ "edad INTEGER)";
		try {
			sentencia = con.createStatement();
			sentencia.executeUpdate(sql0);
			sentencia.executeUpdate(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
