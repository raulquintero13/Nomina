package Views;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Controllers.EmpleadoController;
import Controllers.PuestoController;
import Controllers.TipoEmpleadoController;
import Models.Empleado;
import Models.Nomina;
import Models.Puesto;
import Models.TipoEmpleado;
import Storage.MyData;

public class UIEmpleados {

	
	
	
	public static void menu(String message) {
		int opcionInt;
		UI.clearScreen();
		System.out.println("=================================================================\n");
		System.out.println("Menu > Empleados/Directivos\n");
		System.out.println("                    1. Agregar Empleado                               ");
		System.out.println("                    2. Eliminar Empleado                              ");
		System.out.println("                    3. Actualizar Empleado                               ");
		System.out.println("                    4. Buscar Empleado                               ");
		System.out.println("                                                         ");
		System.out.println("                    5. Mostrar Todos                               ");
		System.out.println("                    0. Menu Anterior                               ");
		System.out.println("\n\n=================================================================");
		System.out.println(message + "\n=================================================================\n\n");
		System.out.print("Seleccione una opcion: \n~$> ");

		do {
			opcionInt = UI.obtenerRespuestaInt();
		}while(opcionInt<0);
		
		switch(opcionInt) {
			case 1: agregarEmpleado();break;
			case 2: eliminarEmpleado(); break;
			case 3: actualizarEmpleado();break;
			case 4: buscarEmpleadoPorId();break;
			case 5: mostrarTodos();break;
			case 0: UI.menu("");break;
			case -1: menu("opcion Invalida");break;
			default: break;
		}
		
	}
	public static void eliminarEmpleado() {
		UI.clearScreen();
		int index;
		int resp;
		String message = "No se Elimino ningun empleado";
		System.out.println("Introduzca el Id del Empleado a eliminar:");
		int id = UI.obtenerRespuestaInt();
		index = MyData.obtenerIndexPorEmpleadoIdEnEmpleados(id);
		if (index==-1)
			UIEmpleados.menu("No existe ese id de empleado");
;		System.out.println("empleado a eliminar: \n");
		System.out.println(EmpleadoController.obtenerPorId(id));
		do {
			System.out.println("Desea eliminar el registro [s/n]?");
			resp = UI.obtenerRespuestaChar();
		}while(resp!='s' && resp!='n');
		if(resp=='s') {
			if (EmpleadoController.eliminarPorId(id))
				message = "Empleado Eliminado";
			else
				message = "Error.- Hubo un problema con el empleado que trato de eliminar";
		}
		UIEmpleados.menu(message);
	}
	public static void actualizarEmpleado() {
		UI.clearScreen();
		int opcion, id,respInt;
		String resp;
		double respDouble;
		do {
			System.out.println("Introduzca el id del empleado a modificar: ");
			id = UI.obtenerRespuestaInt();
		}while(id<=0);
		Empleado empleado = EmpleadoController.obtenerPorId(id);
		if(empleado.getId()<=0) UIEmpleados.menu("Empleado no existe");
		do {
			UI.clearScreen();
			System.out.println("1. Nombre: " +empleado.getNombre());
			System.out.println("2. Apellido: " +empleado.getApellido());
			System.out.println("3. Edad: " +empleado.getEdad());
			System.out.println("4. Domicilio: " +empleado.getDomicilio());
			System.out.println("5. Salario: " +empleado.getSalario());
			if(empleado.getTipoEmpleado().getId() == 2)
				System.out.println("6. Porcentaje de Acciones: " + empleado.getpAcciones());
			System.out.println("\n0.Regresar");
			System.out.println("\nCampo que desea actualizar? ");
			
			opcion = UI.obtenerRespuestaInt();
			switch(opcion) {
				case 1: System.out.println("Nombre: ");
						resp=UI.obtenerRespuesta();
						empleado.setNombre(resp);
						break;
				case 2: System.out.println("Apellido: ");
						resp=UI.obtenerRespuesta();
						empleado.setApellido(resp);
						break;
				case 3: System.out.println("Edad: ");
						respInt=UI.obtenerRespuestaInt();
						empleado.setEdad(respInt);
						break;
				case 4: System.out.println("Domicilio: ");
						resp=UI.obtenerRespuesta();
						empleado.setDomicilio(resp);
						break;
				case 5: System.out.println("Salario: ");
						respDouble=UI.obtenerRespuestaDouble();
						empleado.setSalario(respDouble);
						break;
				case 6: System.out.println("Porcentaje de Acciones:");
						respInt=UI.obtenerRespuestaInt();
						empleado.setpAcciones(respInt);
						break;
				case 0: UIEmpleados.menu("No se Actualizo el registro.");
						resp=UI.obtenerRespuesta();
						empleado.setNombre(resp);
						break;
				default: break;
					
			}
		}while(opcion>0);

		UIEmpleados.menu("");
	}
	public static void agregarEmpleado() {
		UI.clearScreen();
		int opcionInt, respInt;
		double respDouble;
		List<Integer> idsTipoEmpleados = MyData.getTiposEmpleados().stream().map(x->x.getId()).collect(Collectors.toList());
		List<Integer> idsPuestos = MyData.getPuestos().stream().map(x->x.getId()).collect(Collectors.toList());

		if (MyData.getTiposEmpleados().size()==0) UIEmpleados.menu("El catalogo de TipoEmpleado esta vacio  en la BD: " 
			+ MyData.getTiposEmpleados().size());
		if (MyData.getPuestos().size()==0) UIEmpleados.menu("El catalogo de puestos esta vacio en la BD");
		Empleado empleado = new Empleado();
		Puesto puesto = new Puesto();
		TipoEmpleado tipoEmpleado = new TipoEmpleado();
		
		
		System.out.println("Capturar nuevo Empleado\n=========================\n");
		
		do {
			for(TipoEmpleado x : MyData.getTiposEmpleados()) 
				System.out.println("[" + x.getId()+"]"+ x.getNombre());
			System.out.println("Tipo de Empleado: ");
			opcionInt = UI.obtenerRespuestaInt();
		}while(!idsTipoEmpleados.contains(opcionInt));

		TipoEmpleado tE = TipoEmpleadoController.obtenerPorId(opcionInt);
		empleado.setTipoEmpleadoId(tE);
		
		System.out.print("nombre: "); empleado.setNombre(UI.obtenerRespuesta());
		System.out.print("apellido: "); empleado.setApellido(UI.obtenerRespuesta());
		do {
			System.out.print("edad: "); respInt = UI.obtenerRespuestaInt();
		}while(respInt<=0);
		empleado.setEdad(respInt);
		System.out.print("domicilio: "); empleado.setDomicilio(UI.obtenerRespuesta());
		do {
			System.out.println("salario: (debe ser mayor a 0"); 
			respDouble = UI.obtenerRespuestaDouble();
		}while(respDouble<=0);
		empleado.setSalario(respDouble);
		System.out.println("aqui");
		if(tipoEmpleado.getId()==2) {
			System.out.print("porcentaje Acciones: " + tipoEmpleado.getId()); 
			empleado.setpAcciones(UI.obtenerRespuestaInt());
		}else empleado.setpAcciones(0);
		do {
			MyData.getPuestos().forEach(x->{ System.out.println("[" + x.getId()+"]"+ x.getNombre());});
			System.out.println("Tipo de Empleado: ");
			opcionInt = UI.obtenerRespuestaInt();
		}while(!idsPuestos.contains(opcionInt));
		Puesto p = PuestoController.obtenerPorId(opcionInt);
		empleado.setPuesto(p);
		
		EmpleadoController.agregarEmpleado(empleado);
		UIEmpleados.menu("Empleado Agregado");
	}
	
	public static void buscarEmpleadoPorId() {
		UI.clearScreen();
		System.out.println("Introduzca el Id del Empleado:");
		int opcionInt = UI.obtenerRespuestaInt();
		UI.clearScreen();
		mostrarEmpleado(EmpleadoController.obtenerPorId(opcionInt));
		System.out.println("\n\nPresione [r]egresar.");
		UI.obtenerRespuestaChar();
		UIEmpleados.menu("");
		
	}
	
	public static void mostrarEmpleado(Empleado empleado) {
		UI.clearScreen();
		if(empleado.getId()>0)
			System.out.println("Info del Empleado:\n\n\n" 
				+ empleado.toString());
		else
			System.out.println("\nRegistro no encontrado. \n");
		System.out.println("\n\nPresione [r]egresar.");
		UI.obtenerRespuestaChar();
		UIEmpleados.menu("");
	}
	
	public static void mostrarTodos() {
		UI.clearScreen();
		System.out.println("Lista de empleados\n\n");
		List<Empleado> empleados = EmpleadoController.obtenerTodos(); 
		
		empleados.sort(new Comparator < Empleado > () {
            @Override
            public int compare(Empleado n1, Empleado n2) {
                return n1.getTipoEmpleado().getId() > n2.getTipoEmpleado().getId() ? -1 : 1;
            }
        });
		empleados.forEach(empleado -> System.out.println(empleado.toString()));
		System.out.println("\n\nPresione [r]egresar.");
		UI.obtenerRespuestaChar();
		UIEmpleados.menu("");
	}
	
}
