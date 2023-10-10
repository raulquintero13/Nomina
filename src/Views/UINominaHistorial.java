package Views;

import java.util.Comparator;
import java.util.List;

import Controllers.NominaHistorialController;
import Models.Empleado;
import Models.Nomina;

public class UINominaHistorial {

	public static void menu(String message) {
		int opcionInt;
		UI.clearScreen();
		System.out.println("==============================================================================");
		System.out.println("Configuracion                                                          ");
		System.out.println("                    1. Por Meses                                  ");
		System.out.println("                    2. Total Menor a Mayor                               ");
		System.out.println("                    3. Total Mayor a Menor                               ");
		System.out.println("                    												");
		System.out.println("                    0. Menu Anterior                               ");
		System.out.println("\n\n=================================================================\n");
		System.out.println(message + "\n=================================================================\n\n");
		System.out.print("Seleccione una opcion: \n~$> ");

		do {
			opcionInt = UI.obtenerRespuestaInt();
		}while(opcionInt<0);
		
		switch(opcionInt) {
			case 1: porMeses(); break;
			case 2: porTotalAsc();break;
			case 3: porTotalDesc();break;
			case 0: UINomina.menu(""); break;
			case -1: menu("opcion Invalida");break;
			default: break;
		}
		
		
	}

	private static void porTotalDesc() {
		List <Nomina> nominaHistorial = NominaHistorialController.porTotalDesc();
		
		nominaHistorial.forEach(empleado -> System.out.println(empleado.toString()));
		System.out.println("\n\nPresione [r]egresar.");
		UI.obtenerRespuestaChar();
		menu("");
	}

	private static void porTotalAsc() {
		List <Nomina> nominaHistorial = NominaHistorialController.porTotalAsc();
		
		nominaHistorial.forEach(empleado -> System.out.println(empleado.toString()));
		System.out.println("\n\nPresione [r]egresar.");
		UI.obtenerRespuestaChar();
		menu("");
	}

	private static void porMeses() {
		
		List<Nomina> nominaHistorial = NominaHistorialController.porMeses();
		
		nominaHistorial.forEach(empleado -> System.out.println(empleado.toString()));
		System.out.println("\n\nPresione [r]egresar.");
		UI.obtenerRespuestaChar();
		menu("");
		
	}

}
