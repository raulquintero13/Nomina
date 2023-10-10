package Views;

import java.util.List;

import Controllers.EmpleadoController;
import Controllers.PuestoController;
import Controllers.TipoEmpleadoController;
import Models.Empleado;
import Models.Puesto;
import Models.TipoEmpleado;

public class UIPuestos {

	public static void menu(String message) {
		int opcionInt;
		UI.clearScreen();
		System.out.println("=================================================================");
		System.out.println("Menu > Puestos\n\n                                              ");
		System.out.println("                                                          ");
		System.out.println("                    1. Agregar Puesto                               ");
		System.out.println("                    2. Editar Puesto                              ");
		System.out.println("                    3. Mostrar Todos                              ");
		System.out.println("                    0. Menu Anterior                               ");
		System.out.println("                                                         ");
		System.out.println("\n\n=================================================================");
		System.out.println(message + "\n=================================================================");
		System.out.print("Seleccione una opcion: \n~$> ");
		
		do {
			opcionInt = UI.obtenerRespuestaInt();
		}while(opcionInt<0);
		
		switch(opcionInt) {
			case 1: agregarPuesto(); break;
			case 2: editarPuesto(); break;
			case 3: mostrarPuestos();break;
			case 0: UI.menu("");; break;
			case -1: menu("Opcion Invalida"); break;
			default: break;
		}
	}
	
	
	public static void agregarPuesto() {
		double respDouble;
		String resp;
		Puesto puesto = new Puesto();
		do {
			System.out.println("No se permite el nombre [directivo]");
			System.out.print("Nombre de Puesto: ");
			resp = UI.obtenerRespuesta();
		}while(resp.toLowerCase().equals("directivo"));
		puesto.setNombre(resp);
		do {
			System.out.println("Salario Por Dia: [tipo Double] ");
			respDouble = UI.obtenerRespuestaDouble();
		}while(respDouble<0.00);
				
		puesto.setSalarioDia(respDouble);
		do {
			System.out.println("Pago por Hora Extra: [tipo Double]");
			respDouble = UI.obtenerRespuestaDouble();
		}while(respDouble<0.00);
		puesto.setPagoHExtra(respDouble);
		PuestoController.agregarPuesto(puesto);
		UIPuestos.menu(" ++ Registro Agregado: " + puesto.getNombre());
	}
	
	public static void editarPuesto() {
		UI.clearScreen();
		System.out.println("Introduzca el Id del Puesto: ");
		int respuestaInt = UI.obtenerRespuestaInt();
		UIPuestos.menu(" + + Opcion por implementar");
		
	}
	
	public static void mostrarPuestos() {
		UI.clearScreen();
		System.out.println("Lista de Puestos\n\n");
		List<Puesto> puestos = PuestoController.obtenerTodos(); 
		puestos.forEach(puesto -> System.out.println(puesto.toString()));
		System.out.println("\n\nPresione [r]egresar.");
		UI.obtenerRespuestaChar();
		UIPuestos.menu("");
	}
	
	
	
}
