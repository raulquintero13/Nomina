package Views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Controllers.EmpleadoController;
import Controllers.NominaController;
import Models.Empleado;
import Models.Nomina;
import Storage.MyData;

public class UINomina {
	public static void menu(String message) {
		int opcionInt;
		UI.clearScreen();
		List<Integer> pSeleccionado = MyData.obtenerPeriodoSeleccionado();
		System.out.println("=================================================================");
		System.out.println("Menu > Nominas [ Periodo: " + pSeleccionado.get(0) + " - " + pSeleccionado.get(1) + " ]  \n\n");
		//Si no esta seleccionado el periodo para generar la nomina
		if(MyData.obtenerPeriodoSeleccionado().get(0)!=0) {
			System.out.println("                    1. Reg Dias Trabajados por Empleado                              ");
			System.out.println("                    2. Reg Dias Trabajados a Todos                              ");
			System.out.println("                                                 ");
			System.out.println("                    3. Reg Horas Extra porEmpleado                               ");
			System.out.println("                    4. Reg Horas Extras a todos los empleados                  ");
			System.out.println("                                                ");

			System.out.println("                    5. Generar Nomina por Empleado                               ");
			System.out.println("                    6. Generar Nomina Global                            ");
			System.out.println("                    7. Historial Nomina en memoria  >>                            ");
			System.out.println("                                                ");

		}
//		System.out.println("                    8. Mostrar Nomina en memoria                              ");
		System.out.println("                    9. Seleccionar Periodo                               ");
		System.out.println("                    0. Menu Anterior                               ");
		System.out.println("\n\n=================================================================");
		System.out.println(message + "\n=================================================================\n\n");
		System.out.print("Seleccione una opcion: \n~$> ");

		do {
			opcionInt = UI.obtenerRespuestaInt();
		}while(opcionInt<0);
		
		switch (opcionInt) {
		case 1: regDiasTrabPorEmpleado();break;
		case 2: regDiasTrabTodos();break;
		case 3:	regHExtrasPorEmpleado();break;
		case 4:	regHExtrasSoloEmpleados();break;
		case 5: generarNominaPorEmpleado();break;
		case 6: generarNominaGlobal(); break;
		case 7: UINominaHistorial.menu("");
		case 8: mostrarNomina();break;
		case 9: seleccionarPeriodo(); break;
		case 0: UI.menu("");break;
		default: break;
		}

	}
	
	public static void generarNominaPorEmpleado() {
		UI.clearScreen();
		int id;
		System.out.println("Nomina por Empleado");
		do {
			System.out.println("Introduce el id del empleado: ");
			id=UI.obtenerRespuestaInt();
		}while(id<0);
		Nomina nominaPorEmpleado = NominaController.generarNominaPorEmpleado(id);
		System.out.println(nominaPorEmpleado);
		System.out.println("\nPresione [r] regresar: ");
		UI.obtenerRespuestaChar();
		UINomina.menu("");
	}
	
	public static void generarNominaGlobal() {
		char resp;
		UI.clearScreen();
		List<Nomina> nominaGlobal = NominaController.generarNominaGlobal();
		nominaGlobal.forEach(x->System.out.println(x.toString()));
		System.out.println("\nNomina Generada");
		
		System.out.println("\nDesea GrabarNomina [s/n]? ");
		resp = UI.obtenerRespuestaChar();
		if(resp == 's') {
			NominaController.save(nominaGlobal);
		}
		
		
		
		menu("");
		
	}
	
	public static void mostrarNomina() {
		UI.clearScreen();
		List<Nomina> nomina = NominaController.obtenerTodosPorPeriodo();
		System.out.println("\nListado de Nomina\n");
		nomina.sort(new Comparator < Nomina > () {
            @Override
            public int compare(Nomina n1, Nomina n2) {
                return n1.getTipoEmpleado() > n2.getTipoEmpleado() ? -1 : 1;
            }
        });
		nomina.forEach(n->{
			System.out.println(n.toString());
		});
		System.out.println("\nPresiona [r]egresar");
		UI.obtenerRespuestaChar();
		menu("");
		
	}

	public static void regDiasTrabPorEmpleado() {
		int id,dias;
		UI.clearScreen();
		do {
			System.out.print("Introduce el id del empleado: ");
			id = UI.obtenerRespuestaInt();
		}while(id<=0);
		Empleado empleado = EmpleadoController.obtenerPorId(id);
		if (empleado.getId()<=0) 
			UINomina.menu("Ese empleado no existe");
		System.out.println("nombre: " + empleado.getNombre()+ " " + empleado.getApellido());
		do {
			System.out.print("\nCuantas Horas Trabajo? ");
			dias = UI.obtenerRespuestaInt();
		}while (dias<1 || dias >20);

		NominaController.registrarDiasPorEmpleadoId(id, dias);
		System.out.println("Dias Regitrados \n Presione [r]egrear");
		UI.obtenerRespuestaChar();
		menu("");
	}

	public static void regDiasTrabTodos() {
		UI.clearScreen();
		int dias;
		List<Integer> periodo = MyData.obtenerPeriodoSeleccionado();
		System.out.println("Periodo ["+periodo.get(0)+" -"+periodo.get(1)+" ]");
		System.out.println("Registrar Dias Trabajados a todos los empleados. ");
		do {
			System.out.println("Cuantas Dias quiere agregar a los empleados? ");
			dias = UI.obtenerRespuestaInt();
		}while (dias<1 || dias>20);
		NominaController.registrarDiasTEmpleados(dias);
		menu("Se agregaron " + dias + " dias a todos los empleados");
		
	}

	public static void regHExtrasPorEmpleado() {
		int id, horas;
		UI.clearScreen();
		do {
			System.out.print("Introduce el id del empleado: ");
			id = UI.obtenerRespuestaInt();
		}while(id<=0);
		Empleado empleado = EmpleadoController.obtenerPorId(id);
		if (empleado.getId()<=0) 
			UINomina.menu("Ese empleado no existe");
		System.out.println("nombre: " + empleado.getNombre()+ " " + empleado.getApellido());
		do {
			System.out.print("\nCuantas Horas Trabajo? ");
			horas = UI.obtenerRespuestaInt();
		}while (horas<1 || horas>40);
		//TODO:agregar hExtras==========================
		NominaController.registrarHExtrasPorEmpleadoId(id, horas);
		UINomina.menu("Se registraron las horas con exito");
	}
	// no se deben registar horas extras a directivos
	public static void regHExtrasSoloEmpleados() {
		int horasExtras;
		UI.clearScreen();
		List<Integer> periodo = MyData.obtenerPeriodoSeleccionado();
		System.out.println("Periodo ["+periodo.get(0)+" -"+periodo.get(1)+" ]");
		System.out.println("Registrar Horas Extras a todos los empleados. ");
		do {
			System.out.println("Cuantas Horas quiere agregar a los empleados? ");
			horasExtras = UI.obtenerRespuestaInt();
		}while (horasExtras<1 || horasExtras>40);
		NominaController.registrarHExtrasTEmpleados(horasExtras);
		UINomina.menu("Horas Extras Registradas: " + horasExtras);
		menu("Se agregaron " + horasExtras + " horas Extras solo a los empleados(No dorectivos)");
	}
	
	public static void seleccionarPeriodo() {
		UI.clearScreen();
		int year, month;
		System.out.println("Seleeciona Periodo\n");
		do {
			System.out.println("Año [2020 - 2023]? ");
			year = UI.obtenerRespuestaInt();
		}while(year<2020 || year>2023);
		do {
			System.out.println("Mes [1 - 12]? ");
			month = UI.obtenerRespuestaInt();
		}while(month<1 && month>12);
		List<Integer> periodo = new ArrayList<Integer>(Arrays.asList(year,month));
		NominaController.seleccionarPeriodo(periodo);
		menu("Periodo Seleccionado ["+periodo.get(0)+"-" + periodo.get(1)+"]");

		
		
		
	}
}
