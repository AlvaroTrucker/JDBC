package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeleccionDatos {
	private static Statement sentencia;
	private static PreparedStatement sentenciaPreparada;
	public static List<Usuario> getTodosUsuarios(Connection conexion){
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			sentencia = conexion.createStatement();
			String sql = "SELECT * FROM usuario";
			ResultSet resultado = sentencia.executeQuery(sql);
			while(resultado.next()){
				/*String nombre = resultado.getString("nombre");
				int edad = resultado.getInt("edad");
				Usuario usuario = new Usuario(nombre, edad);
				lista.add(usuario);*/
				lista.add(new Usuario(resultado.getString("nombre"),resultado.getInt("edad")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	//metodo que devuelve una lista de usuarios dada la edad
	public static List<Usuario> getUsuariosSegunEdad(Connection conexion, int edad){
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuario WHERE edad > ?";
		try {
			sentenciaPreparada = conexion.prepareStatement(sql);
			sentenciaPreparada.setInt(1, edad);
			ResultSet resultado = sentenciaPreparada.executeQuery();
			while(resultado.next()){
				lista.add(new Usuario(resultado.getString("nombre"),resultado.getInt("edad")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
