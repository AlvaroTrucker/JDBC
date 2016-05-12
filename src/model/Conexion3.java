package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexion3 {
	/*private static final String DB_URL = "jdbc:sqlite:database.db";
	private static final String DRIVER = "org.sqlite.JDBC";*/
	private static Connection conexion3 = null; 
	private Conexion3(){}; //nadie puede crear objetos
	public static Connection getConexion3(){
		//usamos la filosofia del patron Singleton
		if(conexion3 == null){
			//trabajamos con un fichero de propiedades
			ResourceBundle rb = ResourceBundle.getBundle("sqlite");
			String url = rb.getString("url");
			String driver = rb.getString("driver");
			//cargamos el driver
			try {
				//cargarmos el driver
				Class.forName(driver);
				//cargamos la BD
				conexion3 = DriverManager.getConnection(url);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conexion3;
	}
}
