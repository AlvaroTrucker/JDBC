package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.sqlite.SQLiteConfig;

public class Conexion5 {
	/*private static final String DB_URL = "jdbc:sqlite:database.db";
	private static final String DRIVER = "org.sqlite.JDBC";*/
	private static Connection conexion5 = null; 
	private Conexion5(){}; //nadie puede crear objetos
	public static Connection getConexion5(){
		//vamos a cerrar la conexion usando un hook
		Runtime.getRuntime().addShutdownHook(new MiShutdownHuk());
		//usamos la filosofia del patron Singleton
		if(conexion5 == null){
			//trabajamos con un fichero de propiedades
			ResourceBundle rb = ResourceBundle.getBundle("sqlite");
			String url = rb.getString("url");
			String driver = rb.getString("driver");
			//cargamos el driver
			try {
				//cargarmos el driver
				Class.forName(driver);
				//establecemos una configuracion particular
				SQLiteConfig configuracion = new SQLiteConfig();
				configuracion.enforceForeignKeys(true);
				//cargamos la BD
				conexion5 = DriverManager.getConnection(url, configuracion.toProperties());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conexion5;
	}
	static class MiShutdownHuk extends Thread{

		@Override
		public void run() {
			//Connection con = Conexion5.getConexion5();
			if (conexion5 != null){
				try {
					conexion5.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
