package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexion4 {
	/*private static final String DB_URL = "jdbc:sqlite:database.db";
	private static final String DRIVER = "org.sqlite.JDBC";*/
	private static Connection conexion4 = null; 
	private Conexion4(){}; //nadie puede crear objetos
	public static Connection getConexion4(){
		//vamos a cerrar la conexion usando un hook
		Runtime.getRuntime().addShutdownHook(new MiShutdownHuk());
		//usamos la filosofia del patron Singleton
		if(conexion4 == null){
			//trabajamos con un fichero de propiedades
			ResourceBundle rb = ResourceBundle.getBundle("sqlite");
			String url = rb.getString("url");
			String driver = rb.getString("driver");
			//cargamos el driver
			try {
				//cargarmos el driver
				Class.forName(driver);
				//cargamos la BD
				conexion4 = DriverManager.getConnection(url);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conexion4;
	}
	static class MiShutdownHuk extends Thread{

		@Override
		public void run() {
			Connection con = Conexion4.getConexion4();
			if (con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
