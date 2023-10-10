package Views;

import Controllers.TipoEmpleadoController;
import Models.TipoEmpleado;

public class UITipoEmpleado {
	public static void menu(String message) {
		int opcionInt;
		UI.clearScreen();
		System.out.println("=================================================================");
		System.out.println("Tipos de Empleados\n\n                                              ");
		System.out.println("                                                          ");
		System.out.println("                    1. Agregar Tipo                               ");
		System.out.println("                    2. Editar Tipo                              ");
		System.out.println("                    3. Eliminar Tipo                              ");
		System.out.println("                    0. Menu Anterior                               ");
		System.out.println("                                                         ");
		System.out.println("\n\n=================================================================");
		System.out.println(message + "\n=================================================================");
		System.out.print("Seleccione una opcion: \n~$> ");
				
		do {
			opcionInt = UI.obtenerRespuestaInt();
		}while(opcionInt<0);
		
		switch(opcionInt) {
			case 1: agregarTipoEmpleado();break;
			case 2: break;
			case 3: break;
			case 0: UINominaHistorial.menu(""); break;
			case -1: menu("Opcion Invalida"); break;
			default: break;
		}
	}
	
	
	public static void agregarTipoEmpleado() {
		TipoEmpleado tipoEmpleado = new TipoEmpleado();
		System.out.print("Tipo de Empleado: ");
		tipoEmpleado.setNombre(UI.obtenerRespuesta());
		TipoEmpleadoController.agregarTipoEmpleado(tipoEmpleado);
		UITipoEmpleado.menu(" ++ Registro Agregado: " + tipoEmpleado.getNombre());
		
	}
}
