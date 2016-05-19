package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class UsuarioDAOImpSQLite implements UsuarioDAO {
	private Connection conexion = Conexion5.getConexion5();
	private static PreparedStatement sentencia;
	
	@Override
	public void insertarUsuarioDTO(Usuario u) {
		String sql = "INSERT INTO usuario (nombre, edad) VALUES"
				+ "(?,?) ";
		try {
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, u.getNombre());
			sentencia.setInt(2, u.getEdad());
			sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrarUsuarioDTO(Usuario u) {
		String sql = "DELETE FROM usuario WHERE "
				+ "nombre = ?";
		try {
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, u.getNombre());
			sentencia.setInt(2, u.getEdad());
			sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
