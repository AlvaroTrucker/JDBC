package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion1 {
	private static final String DB_URL = "jdbc:sqlite:database.db";
	private static final String DRIVER = "org.sqlite.JDBC";
	private static Connection conexion1; 
	public static Connection getConexion1(){
		//cargamos el driver
		try {
			//cargarmos el driver
			Class.forName(DRIVER);
			//cargamos la BD
			conexion1 = DriverManager.getConnection(DB_URL);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion1;
	}
}
