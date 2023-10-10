package Storage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Models.Empleado;
import Models.Nomina;
import Models.Puesto;
import Models.TipoEmpleado;
import Views.UI;


public class MyData {
	
	private static List<Nomina> nomina = new ArrayList<Nomina>();
	private static List<Nomina> nominaHistorial = new ArrayList<Nomina>();
	private static List<Empleado> empleados = new ArrayList<Empleado>();
	private static List<Puesto> puestos = new ArrayList<Puesto>();
	private static List<TipoEmpleado> tiposEmpleados = new ArrayList<TipoEmpleado>();
	private static List<Integer> periodoSeleccionado = new ArrayList<Integer>(Arrays.asList(0, 0));
	
	//No se comtempla por el momento trabajar con mas tipos de emplados
	public static void init() {
		tiposEmpleados.add(new TipoEmpleado(1, "Empleado"));
		tiposEmpleados.add(new TipoEmpleado(2, "Directivo"));
	}
	
	public static List<Integer> obtenerPeriodoSeleccionado(){
		return periodoSeleccionado;
	}
	public static boolean setPeriodoSeleccionado(List<Integer> periodo) {
		periodoSeleccionado.set(0, periodo.get(0));
		periodoSeleccionado.set(1, periodo.get(1));
		return true;
	}
	
	public static boolean estaVacioPeriodoNomina(List<Integer> pSeleccionado) {
		boolean n = nomina.stream()
					.filter(x-> (x.getYear()==pSeleccionado.get(0) && x.getMonth() == pSeleccionado.get(1)))
					.toList()
					.isEmpty();
			 
		return n;
	}
	public static boolean cargarDatosEmpleados(List<Nomina> nominaEmpleados) {
		nomina.clear();
		nomina.addAll(nominaEmpleados);
		
		return true;
	}
	public static List<Nomina> getNomina() {
		return nomina;
	}
	public static List<Nomina> getNominaHistorial() {
		return nominaHistorial;
	}
	
	/**************************************************
	 *                    Empleados
	 */
	public static List<Empleado> getEmpleados() {
		return empleados;
	}
	public static Boolean addEmpleado(Empleado e) {
		int max = 0;
		for(Empleado x: empleados) {
			max=(max > x.getId())? max : x.getId();
		}
		e.setId(max+1);
		empleados.add(e);
		return true;
	}
	public static boolean eliminarEmpleadoPorIndex(int index) {
		boolean estado;
		try {
			empleados.remove(index);
			estado = true;
		}catch(Exception e) {
			estado =false;
		}
		return estado;
	}
	public static boolean actaulizarEmpleadoPorId(int id, Empleado empleado) {
		int index = obtenerIndexPorEmpleadoIdEnEmpleados(id);
		empleados.set(id-1,empleado);
		return true;
	}
	
	public static Empleado obtenerEmpleadoPorId (int id) {
		Empleado empleado;
		try {
			empleado = empleados.stream()
					.filter(emp -> emp.getId()== id)
					.findFirst()
					.get();
			
		}catch(Exception e) {
			empleado = new Empleado();
		}

		return empleado;
	}
	
	public static int obtenerIndexPorEmpleadoIdEnEmpleados(int id) {
		int index=0;
		for(Empleado e: empleados) {
			if(e.getId() == id) 
				return index;
			index++;
		}
		return -1;
	}
	/*********************************************************
	 *  Tipos de Empleados
	 */
	
	
	public static List<TipoEmpleado> getTiposEmpleados(){
		return tiposEmpleados;
	}
	public static void addTipoEmpleado(TipoEmpleado tE) {
		
		int  id;
		if(tiposEmpleados.size() == 0) 
			id =1;
		else {
			id=2;
			//ToDo = get last id
		}
		tiposEmpleados.add(new TipoEmpleado( id ,tE.getNombre() ));
	
	}
	public static TipoEmpleado obtenerTipoEMpleadoPorId(int id) {
		for (TipoEmpleado tE: tiposEmpleados) {
			if (tE.getId()==id)
				return tE;
		}
		return new TipoEmpleado();
	}
	
	/***************************************************
	 * Puestos
	 */
	public static List<Puesto> getPuestos(){
		return puestos;
	}
	public static void insertarPuesto(Puesto puesto) {
		int  id, max=0;

		for(Puesto x: puestos) {
			max=(max > x.getId())? max : x.getId();
		}
		puesto.setId(max+1);
		puestos.add( puesto );
	}
	public static boolean eliminarPuestoPorId(int id) {
		
		return true;
	}

	public static Puesto obtenerPuestoPorId(int id) {
		for(Puesto p: puestos) {
			if(p.getId()==id)
				return p;
		}
		return new Puesto();
	}
	
	/*************************************************
	 * Nomina
	 */
	public static Nomina obtenerEmpleadoPorIdEnNomina(int index) {
		return nomina.get(index);
		
	}
	
	/******************************************************************
	 *          DEMO
	 */
	public static void loadDemoData() {
		//                        id|nombre|apellido|edad|domicilio|sueldo| Part. Acciones| |id|nombre|sueldoDia|pagoHExtras  |  |
		empleados.add(new Empleado(1,"Juan", "perez", 18,"la joya 710", 1500.00, 0, new Puesto(1,"tecnico", 150.00, 170.00), new TipoEmpleado(1, "empleado")));
		empleados.add(new Empleado(2,"Pedro", "martinez", 30,"bucarelli 100", 2500.00, 0, new Puesto(1,"tecnico", 150.00, 170.00), new TipoEmpleado(1, "empleado")));
		empleados.add(new Empleado(3,"maria", "mercedes",45,"la condesa 2234", 2500.00, 0, new Puesto(2,"gerente", 150.00, 170.00), new TipoEmpleado(2, "directivo")));
		empleados.add(new Empleado(4,"jose", "lopez",35,"la condesa 2234", 2500.00, 0, new Puesto(3,"soporte", 150.00, 170.00), new TipoEmpleado(1, "empleado")));
		empleados.add(new Empleado(5,"rosa", "uribe",23,"la condesa 2234", 2500.00, 0, new Puesto(2,"gerente", 150.00, 170.00), new TipoEmpleado(2, "directivo")));
		empleados.add(new Empleado(6,"zulema", "velasquez",44,"la condesa 2234", 2500.00, 0, new Puesto(3,"soporte", 150.00, 170.00), new TipoEmpleado(1, "empleado")));
		empleados.add(new Empleado(7,"francisco", "flores",65,"la condesa 2234", 2500.00, 0, new Puesto(4,"asistente", 150.00, 170.00), new TipoEmpleado(1, "empleado")));
		puestos.add(new Puesto(1,"tecnico", 500.00, 800.00));
		puestos.add(new Puesto(2,"gerente", 1000.00, 1700.00));
		puestos.add(new Puesto(3,"soporte", 350.00, 650.00));
		puestos.add(new Puesto(4,"asistente", 450.00, 700.00));
		
		System.out.println("catalogo de emplados: \n");
		for(Empleado e: empleados) {System.out.println(e);}
		System.out.println("\nCatalogo de Puestos\n");
		for(Puesto p: puestos) {System.out.println(p);}
		puestos.forEach(x->System.out.println(x));
	}

	public static void registrarHExtrasTEmpleados(int horas) {
		for(Nomina n: nomina){
			if(n.getYear() == periodoSeleccionado.get(0)  
					&& n.getMonth()== periodoSeleccionado.get(1)
					&& n.getTipoEmpleado() != 2)// no aplica a directivos
				n.setHorasExtras(horas);
		};
		
	}

	public static void registrarDiasTEmpleados(int dias) {
		for(Nomina n: nomina){
			if(n.getYear() == periodoSeleccionado.get(0)  
					&& n.getMonth()== periodoSeleccionado.get(1))
				n.setDiasTrabajados(dias);
		};
	}

	public static int obtenerIndexPorEmpleadoIdEnNomina(int id) {
		// TODO Auto-generated method stub
		int index=0;
		for(Nomina e: nomina) {
			if(e.getEmpleadoId() == id) 
				return index;
			index++;
		}
		return -1;
	}

	public static void registrarDiasPorEmpleadoId(int id, int dias) {
		int index = obtenerIndexPorEmpleadoIdEnNomina(id);
		Nomina empleado = nomina.get(index);
		empleado.setDiasTrabajados(dias);
		nomina.set(index, empleado);
	}

	public static void registrarHExtrasPorEmpleadoId(int id, int horas) {
		int index = obtenerIndexPorEmpleadoIdEnNomina(id);
		Nomina empleado = nomina.get(index);
		
		if(empleado.getTipoEmpleado()!=2) { //no aplicar a directivos
			empleado.setHorasExtras(horas);
			nomina.set(index, empleado);
		}
	}

	public static void saveNomina(List<Nomina> nominaGlobal) {
		
		nominaGlobal.forEach(x->{nominaHistorial.add(x);});
//		nominaHistorial.forEach(empleado -> System.out.println(empleado.toString()));
		
		System.out.println("Presione [r]egresar");
		UI.obtenerRespuestaChar();
		

	}
	

	
	
	
	
	
	
	
	
	
	
}
