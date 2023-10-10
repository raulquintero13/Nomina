package Controllers;

import java.util.List;

import Models.Empleado;
import Models.Puesto;
import Storage.MyData;
import Views.UI;

public class PuestoController {

	public static void agregarPuesto(Puesto puesto) {
		MyData.insertarPuesto(puesto);
	}
	
	public static boolean eliminarPuestoPorId(int id) {
		return true; //MyData.eliminarPuestoPorId();
	}
	
	public static List<Puesto> obtenerTodos() {
		return MyData.getPuestos();
	}
	public static Puesto obtenerPorId(int id) {
		return MyData.obtenerPuestoPorId(id);
	}
	
	
}
