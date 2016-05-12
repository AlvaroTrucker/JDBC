package model;

import java.sql.Connection;

public class TestBD {

	public static void main(String[] args) {
		Connection conexion1 = Conexion1.getConexion1();
		Connection conexion2 = Conexion2.getConexion2();
		Connection conexion3 = Conexion3.getConexion3();
	}

}
