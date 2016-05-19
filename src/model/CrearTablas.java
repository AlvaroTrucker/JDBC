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
	
	public static void crearTrigger(Connection con){
		//creamos la tabla historial
		String sql1 = "CREATE TABLE IF NOT EXISTS historial ("
				+"id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+"nombre TEXT,"
				+"edad INTEGER,"
				+"fecha_baja TEXT"
				+")";
		//creamos el trigger
		String sql2 = " CREATE TRIGGER borrado BEFORE DELETE"
					 +" ON usuario"
					 +" BEGIN"
					 +" INSERT INTO historial (nombre, edad, fecha_baja)"
					 +" VALUES (old.nombre, old.edad, datetime('now'));"
					 +" END";
		try {
			sentencia = con.createStatement();
			sentencia.addBatch(sql1);
			sentencia.addBatch(sql2);
			sentencia.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void crearIndices(Connection con){
		String sql1 = "CREATE INDEX name ON usuario(nombre)";
		String sql2 = "CREATE INDEX age ON usuario(edad)";
		try {
			con.setAutoCommit(false);
			sentencia = con.createStatement();
			sentencia.executeUpdate(sql1);
			sentencia.executeUpdate(sql2);
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
