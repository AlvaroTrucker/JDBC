package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizacionBorrado {
	private static PreparedStatement sentenciaPreparada;
	public static int actualizarNombreUsuario(Connection conexion, String nombreViejo, String nombreNuevo){
		int datosAfectados = 0;
		String sql = "UPDATE usuario SET nombre = ? WHERE nombre = ?";
		try {
			sentenciaPreparada = conexion.prepareStatement(sql);
			sentenciaPreparada.setString(1, nombreNuevo);
			sentenciaPreparada.setString(1, nombreViejo);
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datosAfectados;
	}
	
	public static int borradoNombreUsuario(Connection conexion, String nombre){
		int datosAfectados = 0;
		String sql = "DELETE FROM usuario WHERE nombre = ?";
		try {
			sentenciaPreparada = conexion.prepareStatement(sql);
			sentenciaPreparada.setString(1, nombre);
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datosAfectados;
	}
}
