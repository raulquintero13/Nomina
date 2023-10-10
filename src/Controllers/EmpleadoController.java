package Controllers;

import java.util.List;

import Models.Empleado;
import Storage.MyData;
import Views.UI;
import Views.UIEmpleados;

public class EmpleadoController {

	
	public static boolean agregarEmpleado(Empleado e) {
		return MyData.addEmpleado(e);
	}
	
	public static Empleado obtenerPorId(int id) {
		return  MyData.obtenerEmpleadoPorId(id);

	}
	
	public static boolean actualizar(int id, Empleado empleado) {
		return MyData.actaulizarEmpleadoPorId(id, empleado);
		
	}
	
	public static List<Empleado> obtenerTodos() {
		return MyData.getEmpleados();
	}
	
	
	public static boolean eliminarPorId(int id) {
		int index = MyData.obtenerIndexPorEmpleadoIdEnEmpleados(id);
		return MyData.eliminarEmpleadoPorIndex(index);
	}
}
