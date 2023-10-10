package Views;

import java.util.Scanner;

import Storage.MyData;

public class UI {
	
	public static void clearScreen() {
		for(int x=0;x<50;x++) 
			System.out.println("");
	}
	
	public static void menu(String message) {
		int opcionInt;
		clearScreen();
		System.out.println("=================================================================");
		System.out.println("Menu Principal\n\n                                              ");
		System.out.println("                                                          ");
		System.out.println("                    1. Empleados  >>                             ");
		System.out.println("                    2. Nominas    >>                          ");
		System.out.println("                    3. Puestos    >>                           ");
		System.out.println("                                                   ");
		System.out.println("                    4. Cargar Info (DEMO)                       ");
		System.out.println("                    0. Salir                               ");
		System.out.println("                                                         ");
		System.out.println("\n\n=================================================================");
		System.out.println(message + "\n=================================================================");
		System.out.print("Seleccione una opcion: \n~$> ");
		
		do {
			opcionInt = UI.obtenerRespuestaInt();
		}while(opcionInt<0);
		
		switch(opcionInt) {
			case 1: UIEmpleados.menu("");break;
			case 2: UINomina.menu("");break;
			case 3: UIPuestos.menu("");break;
			case 4: loadInfo(); break;
			case 0: terminarPrograma(); break; 
			case -1: menu("Opcion Invalida"); break;
			default: break;
		}
	}
	
	

	private static void loadInfo() {
		char resp;
		String message;
		clearScreen();
		do {
		System.out.println("Desea cargar informacion para demostracion del sistema [s/n]?");
		resp = obtenerRespuestaChar();
		}while(resp!='s' && resp!='n');
		if(resp=='s') {
			if(MyData.getEmpleados().size()==0) {
				MyData.loadDemoData();
				message = "\nInformacion Cargada.";
			}else message = "La informacion ya habia sido cargada anteriormente.";
			System.out.println(message + "\n\nPresione [R]egresar.");
			resp = obtenerRespuestaChar();
		}
		else  message = "carga de informacion cancelada";
		UI.menu(message);
	}
	
	public static int obtenerRespuestaInt() {
		int opcion;
		Scanner scan = new Scanner(System.in);

		try {
			opcion = scan.nextInt();
		}catch(Exception e ) {
			opcion = -1;
		}
		
		return opcion;
	}
	public static double obtenerRespuestaDouble() {
		double opcion;
		Scanner scan = new Scanner(System.in);

		try {
			opcion = scan.nextDouble();
		}catch(Exception e ) {
			opcion = 0.00;
		}
		
		return opcion;
	}
	public static char obtenerRespuestaChar() {
		Scanner scan = new Scanner(System.in);
		char opcionChar;
		try {
			opcionChar = scan.next().charAt(0);
		}catch(Exception e ) {
			opcionChar = ' ';
		}
		
		return opcionChar;
	}
	public static String obtenerRespuesta() {
		Scanner scan = new Scanner(System.in);
		String opcionStr;
		try {
			opcionStr = scan.next() ;
		}catch(Exception e ) {
			opcionStr = null;
		}
		
		return opcionStr;
	}
	private static void terminarPrograma() {
		UI.clearScreen();  
		System.out.println("Sistema de Nominas Terminado.\n[Raul Quintero]\n\n\n");
		System.exit(0);		
	}
}
