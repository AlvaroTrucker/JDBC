package model;

import java.io.File;
import java.sql.Connection;
import java.util.List;

public class TestBD {

	public static void main(String[] args) {
		Connection conexion1 = Conexion1.getConexion1();
		Connection conexion2 = Conexion2.getConexion2();
		Connection conexion3 = Conexion3.getConexion3();
		Connection conexion4 = Conexion4.getConexion4();
		Connection conexion5 = Conexion5.getConexion5();
		
		//cogemos la ultima conexion para realizar operaciones con la BD
		CrearTablas.crearTablaUsuario(conexion5);
		InsertarDatos.addUsuario(conexion5, new Usuario("pepe",21));
		InsertarDatos.addUsuario(conexion5, new Usuario("joaquin",18));
		
		List<Usuario> lista = SeleccionDatos.getTodosUsuarios(conexion5);
		for (Usuario usuario : lista) {
			System.out.println(usuario);
		}
		
		ActualizacionBorrado.actualizarNombreUsuario(conexion5, "pepe", "jose");
		for (Usuario usuario : lista) {
			if(usuario.getNombre().equals("pepe"))
				usuario.setNombre("jose");
		}
		List<Usuario> listaMayores = SeleccionDatos.getUsuariosSegunEdad(conexion5, 17);
		for (Usuario usuario : listaMayores) {
			System.out.println(usuario);
		}
		
		ActualizacionBorrado.borradoNombreUsuario(conexion5, "pepe");
		
	}

}
