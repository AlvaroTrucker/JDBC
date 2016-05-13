package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private int edad;
	
	/**
	 * @param nombre
	 * @param edad
	 */
	public Usuario(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	public static List<Usuario> usuarioMayorEdad(List<Usuario> lista){
		List<Usuario> listaUsuarioMayorEdad = new ArrayList<Usuario>();
		for (Usuario usuario : listaUsuarioMayorEdad) {
			if(usuario.getEdad() > 17)
				listaUsuarioMayorEdad.add(usuario);
		}
		return listaUsuarioMayorEdad;
	}
	
}
