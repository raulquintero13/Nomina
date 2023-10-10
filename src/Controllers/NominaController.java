package Controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Models.Empleado;
import Models.Nomina;
import Storage.MyData;

public class NominaController {

	public static boolean seleccionarPeriodo(List<Integer> periodo) {
		MyData.setPeriodoSeleccionado(periodo);
		
		List<Empleado> empleados = EmpleadoController.obtenerTodos();
		List<Nomina> nominaEmpleados = new ArrayList<Nomina>();
		
		empleados.forEach(e->{
			Nomina nominaEmpleado = new Nomina();
			nominaEmpleado.setYear(periodo.get(0));
			nominaEmpleado.setMonth(periodo.get(1));
			nominaEmpleado.setEmpleadoId(e.getId());
			nominaEmpleado.setEmpleado(e);
			nominaEmpleado.setTipoEmpleado(e.getTipoEmpleado().getId());
			nominaEmpleado.setSueldoDia(e.getPuesto().getSalarioDia());
			nominaEmpleado.setDiasTrabajados(0);
			nominaEmpleado.setPagoHExtra(e.getPuesto().getPagoHExtra());
			nominaEmpleado.setHorasExtras(0);
			nominaEmpleado.setTotalHExtras(0);
			nominaEmpleado.setTotalSueldo(0);
			
			nominaEmpleados.add(nominaEmpleado);
			
		});
		nominaEmpleados.sort(new Comparator < Nomina > () {
            @Override
            public int compare(Nomina n1, Nomina n2) {
                return n1.getTipoEmpleado() > n2.getTipoEmpleado() ? -1 : 1;
            }
        });
		MyData.cargarDatosEmpleados(nominaEmpleados);
		return true;
	}
	

	public static List<Nomina> obtenerTodosPorPeriodo() {
		 return MyData.getNomina();
		 
	}

	public static void registrarHExtrasTEmpleados(int horas) {
		MyData.registrarHExtrasTEmpleados(horas);
			
		
	}

	public static void registrarDiasTEmpleados(int dias) {
		MyData.registrarDiasTEmpleados(dias);
		
	}
	public static Nomina generarNominaPorEmpleado(int id) {
		int index = MyData.obtenerIndexPorEmpleadoIdEnNomina(id);
		Nomina empleado = MyData.obtenerEmpleadoPorIdEnNomina(index);
		double totalSueldo = empleado.getSueldoDia()*empleado.getDiasTrabajados();
		double totalHExtras = empleado.getPagoHExtra()*empleado.getHorasExtras();
		empleado.setTotalSueldo(totalSueldo);
		empleado.setTotalHExtras(totalHExtras);
		empleado.setTotalSueldoMes(totalSueldo+totalHExtras);
		
		return empleado;
	}


	public static List<Nomina> generarNominaGlobal() {
		List<Nomina> nomina = MyData.getNomina();
		for(Nomina empleado: nomina) {
			double totalSueldo = empleado.getSueldoDia()*empleado.getDiasTrabajados();
			double totalHExtras = empleado.getPagoHExtra()*empleado.getHorasExtras();
			empleado.setTotalSueldo(totalSueldo);
			empleado.setTotalHExtras(totalHExtras);
			empleado.setTotalSueldoMes(totalSueldo+totalHExtras);
		}		
		return nomina;
	}


	public static void registrarDiasPorEmpleadoId(int id, int dias) {
		MyData.registrarDiasPorEmpleadoId(id, dias);
		
	}


	public static void registrarHExtrasPorEmpleadoId(int id, int horas) {
		MyData.registrarHExtrasPorEmpleadoId(id, horas);
	}


	public static void save(List<Nomina> nominaGlobal) {
		MyData.saveNomina(nominaGlobal);
		
	}

}

